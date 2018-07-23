package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.PageView;
import com.pojo.RoomInfo;
import com.pojo.StayInfo;
import com.service.RoomService;

@Controller
public class RoomManager {
	@Autowired
	private RoomService roomService;
	
	/**
	 * 
	 * @param rows 前端收到的行数
	 * @param page 页面数
	 * @return  返回json对象
	 */
	@RequestMapping("/selectList")
	@ResponseBody
	public PageView list(int rows,int page){
		//查询List
		List<RoomInfo> list=roomService.getList(page,rows);
		//查询总条数
		int total=roomService.queryCount();
		
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
	@RequestMapping("/delete")
	@ResponseBody
	public PageView del(Integer id){
		PageView p=new PageView();
		try{
			roomService.delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		p.setMessage("删除成功");
		return p;
	}
	
	
	/**
	 * 添加房间
	 */
	@RequestMapping("/addRoomInfo.do")
	@ResponseBody
	public PageView add(RoomInfo roomInfo){
		PageView p=new PageView();
		try{	
			roomService.addRoom(roomInfo);
			p.setMessage("添加成功！");
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return p; 
		
	}
	
	/**
	 * 
	 * @param 房间信息
	 * @return 返回空房的房间编号
	 */
	
	@RequestMapping("/queryServlet.do")
	public @ResponseBody List query(RoomInfo stay){
		String str=stay.getStatus();
		List<RoomInfo> li=roomService.list(str);
		List list=new ArrayList<>();
		
		for(RoomInfo room:li){
			list.add(room.getRoomId());
		}
		/*JSONObject json=new JSONObject();
		json.put("receiveList", list);*/
		/*System.out.println(json.toString());*/
		return list;
	}
	
	/**
	 * 
	 * @param 入住手续
	 */
	@RequestMapping("/stayInfoServlet.do")
	public void insertStay(StayInfo stay){
		try{	
			roomService.insert(stay);
			roomService.upRoom(stay.getRoomId());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/checkOut")
	@ResponseBody
	public PageView li(int rows,int page){
		//查询List
		List<StayInfo> listStay=roomService.getListStay(rows,page);
		//查询总条数
		int total=roomService.query();	
		PageView pa=new PageView();
		pa.setRows(listStay);
		pa.setTotal(total);
		return pa;
	}
	
	
	@RequestMapping("/checkOutServlet")
	@ResponseBody
	public PageView check(Integer id){
		PageView p=new PageView();
		//设置备注为已退房
		Date date=new Date();
		SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd");
		String out=spdf.format(date);
		roomService.live(id,out);
		//修改房间信息状态
		StayInfo st=roomService.findRoomId(id);
		roomService.up(st.getRoomId());
		p.setMessage("退房手续成功！");
		return p;
	}
	
	
	
	
	
	

}
