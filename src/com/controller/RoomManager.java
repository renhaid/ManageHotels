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
	 * @param rows ǰ���յ�������
	 * @param page ҳ����
	 * @return  ����json����
	 */
	@RequestMapping("/selectList")
	@ResponseBody
	public PageView list(int rows,int page){
		//��ѯList
		List<RoomInfo> list=roomService.getList(page,rows);
		//��ѯ������
		int total=roomService.queryCount();
		
		PageView pa=new PageView();
		pa.setRows(list);
		pa.setTotal(total);
		return pa;
	}
	
	/**
	 * 
	 * @param ɾ������
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
		p.setMessage("ɾ���ɹ�");
		return p;
	}
	
	
	/**
	 * ��ӷ���
	 */
	@RequestMapping("/addRoomInfo.do")
	@ResponseBody
	public PageView add(RoomInfo roomInfo){
		PageView p=new PageView();
		try{	
			roomService.addRoom(roomInfo);
			p.setMessage("��ӳɹ���");
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return p; 
		
	}
	
	/**
	 * 
	 * @param ������Ϣ
	 * @return ���ؿշ��ķ�����
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
	 * @param ��ס����
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
		//��ѯList
		List<StayInfo> listStay=roomService.getListStay(rows,page);
		//��ѯ������
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
		//���ñ�עΪ���˷�
		Date date=new Date();
		SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd");
		String out=spdf.format(date);
		roomService.live(id,out);
		//�޸ķ�����Ϣ״̬
		StayInfo st=roomService.findRoomId(id);
		roomService.up(st.getRoomId());
		p.setMessage("�˷������ɹ���");
		return p;
	}
	
	
	
	
	
	

}
