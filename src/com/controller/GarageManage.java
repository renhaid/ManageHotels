package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.GaraCheckInfo;
import com.pojo.GarageInfo;
import com.pojo.GarageWatierInfo;
import com.pojo.PageView;
import com.pojo.RoomInfo;
import com.pojo.SeatInfo;
import com.service.GarageService;


@Controller
public class GarageManage {
	@Autowired
	private GarageService garaService;
	
	/**
	 * 
	 * @param rows
	 * @param page
	 * @return  json格式信息
	 */
	@RequestMapping("/selectGarageInfo")
	@ResponseBody
	public PageView list(int rows,int page){
		//查询List
		List<GarageInfo> list=garaService.getList(page,rows);
		//查询总条数
		int total=garaService.queryCount();		
		PageView pa=new PageView();
		pa.setRows(list);
		pa.setTotal(total);
		return pa;
	}
	
	/**
	 * 
	 * @param ga
	 * @return 查询空闲的车库人员管理编号
	 */
	@RequestMapping("/queryGarageServlet")
	@ResponseBody
	public List getList(GarageWatierInfo ga){
		List<GarageWatierInfo> li=garaService.getId(ga);
		List list=new ArrayList<>();
		for(GarageWatierInfo s:li){
			list.add(s.getGaraWaiterId());
		}
		return list;	
	}
	
	@RequestMapping("/garageCheckServelet")
	public void insertGaraCheck(GaraCheckInfo ga){
		garaService.add(ga);
		GarageInfo gi=garaService.findGarage();
		garaService.up(gi.getCount()-1);
	}
	
	@RequestMapping("/checkOutGaraCheckInfo")
	@ResponseBody
	public PageView getList(int rows,int page){
		//查询List
		List<GaraCheckInfo> list=garaService.getLi(page,rows);
		//查询总条数
		int total=garaService.query();		
		PageView pa=new PageView();
		pa.setRows(list);
		pa.setTotal(total);
		return pa;
	}
	
	@RequestMapping("/checkOutGarageServlet")
	@ResponseBody
	public PageView del(Integer id){
		PageView pa=new PageView();
		Date date=new Date();
		SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd");
		String garaEndDate=spdf.format(date);
		garaService.upGarageCheckInfo(id,garaEndDate);
		GarageInfo ga=garaService.findGarage();
		garaService.upGaraInfo(ga.getCount()+1);
		pa.setMessage("操作成功！");
		return pa;
		
	}
	

}
