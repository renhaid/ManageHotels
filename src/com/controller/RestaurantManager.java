package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.PageView;
import com.pojo.RestCustInfo;
import com.pojo.RestWaiterInfo;
import com.pojo.RoomInfo;
import com.pojo.SeatInfo;
import com.pojo.StayInfo;
import com.service.ReasturantService;

/**
 * 
 * @author 餐厅管理
 *
 */
@Controller
public class RestaurantManager {
	@Autowired
	private ReasturantService restService;
	
	/**
	 * 
	 * @param rows 行数
	 * @param page 页数
	 * @return
	 */
	@RequestMapping("/selectSeatInfo")
	@ResponseBody
	public PageView getList(int rows,int page){
		//查询List
				List<RoomInfo> list=restService.getList(page,rows);
				//查询总条数
				int total=restService.queryCount();		
				PageView pa=new PageView();
				pa.setRows(list);
				pa.setTotal(total);
				return pa;
		
	}
	
	/**
	 * 
	 * @param 删除数据
	 * @return 
	 */
	@RequestMapping("/delSeatInfo")
	@ResponseBody
	public PageView del(Integer id){
		PageView p=new PageView();
		try{
			restService.delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		p.setMessage("删除成功");
		return p;
	}
	
	/**
	 * 
	 * @param 添加餐桌信息
	 * @return
	 */
	@RequestMapping("addSeatInfo.do")
	@ResponseBody
	public PageView add(SeatInfo seat){
		PageView p=new PageView();
		try{	
			restService.addSeat(seat);
			p.setMessage("添加成功！");
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return p; 
		
	}
	
	
	/**
	 * 查询空闲的座位编号
	 */
	@RequestMapping("/queryReasturantServlet.do")
	@ResponseBody
	public List getList(SeatInfo seat){
		List<SeatInfo> li=restService.getSeatId(seat);
		List list=new ArrayList<>();
		for(SeatInfo s:li){
			list.add(s.getSeatId());
		}
		return list;	
	}
	
	/**
	 * 查询空闲的接待人员编号
	 */
	@RequestMapping("/queryReceptId")
	@ResponseBody
	public List getRecId(RestWaiterInfo res){
		List<RestWaiterInfo> li=restService.getRecId(res);
		List list=new ArrayList<>();
		for(RestWaiterInfo re:li){
			list.add(re.getRestWaiterId());
		}
		return list;
	}
	/**
	 * 
	 * @param stay
	 * @return 查询当前酒店顾客Id
	 */
	@RequestMapping("/queryCustId")
	@ResponseBody
	public List getCustId(StayInfo stay){
		List<StayInfo> li=restService.getCustId(stay);
		List list=new ArrayList<>();
		for(StayInfo st:li){
			list.add(st.getCustId());
		}
		return list;
	}
	
	/**
	 * 
	 * @param 添加顾客用餐信息
	 */
	@RequestMapping("/reasturantServelet")
	public void insertStay(RestCustInfo rst){
		try{	
			restService.insert(rst);
			restService.upSeat(rst.getSeatId());	
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	/**
	 * 
	 * @param rows
	 * @param page
	 * @return  显示当前顾客的用餐信息
	 */
	@RequestMapping("/selectReastCustInfo")
	@ResponseBody
	public PageView getSelectReastCust(int rows,int page){
		//查询List
				List<RestCustInfo> listStay=restService.getReastCust(rows,page);
				//查询总条数
				int total=restService.queryReast();	
				PageView pa=new PageView();
				pa.setRows(listStay);
				pa.setTotal(total);
				return pa;		
	}
	
	/**
	 * 
	 * @return 结束用餐
	 */
	@RequestMapping("/endServlet")
	@ResponseBody
	public PageView end(Integer id){
		PageView pa=new PageView();
		restService.endReast(id);
		RestCustInfo res=restService.getRest(id);
		restService.updateSeatInfo(res.getSeatId());
		pa.setMessage("用餐结束！");
		return pa;
	}
	
		
		
}
