package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.GarageWatierInfo;
import com.pojo.PageView;
import com.pojo.RestWaiterInfo;
import com.pojo.RoomWaiterInfo;
import com.service.PersonSerivce;

@Controller
public class PersonManage {
		@Autowired
		private PersonSerivce perService;
		
		@RequestMapping("/selectRoomWaiter")
		@ResponseBody
		public PageView list(int rows,int page){
			//��ѯList
			List<RoomWaiterInfo> list=perService.getList(page,rows);
			//��ѯ������
			int total=perService.queryCount();
			
			PageView pa=new PageView();
			pa.setRows(list);
			pa.setTotal(total);
			return pa;
		}
		
		@RequestMapping("/addRoomWaiter")
		@ResponseBody
		public PageView add(RoomWaiterInfo room){
			PageView p=new PageView();
			try{	
				perService.addRoom(room);
				p.setMessage("��ӳɹ���");
			}catch(Exception e){
				e.printStackTrace();
			}
					
			return p; 	
		}
		
		@RequestMapping("/delRoomWiter")
		@ResponseBody
		public PageView del(Integer id){
			PageView p=new PageView();
			try{
				perService.delete(id);
			}catch(Exception e){
				e.printStackTrace();
			}
			p.setMessage("ɾ���ɹ�");
			return p;
		}
		
		
		
		@RequestMapping("/selectReastWaiter")
		@ResponseBody
		public PageView getlist(int rows,int page){
			//��ѯList
			List<RestWaiterInfo> list=perService.List(page,rows);
			//��ѯ������
			int total=perService.query();
			PageView pa=new PageView();
			pa.setRows(list);
			pa.setTotal(total);
			return pa;
		}
		
		@RequestMapping("/addReastWaiter")
		@ResponseBody
		public PageView addReast(RestWaiterInfo rest){
			PageView p=new PageView();
			try{	
				perService.addReastWaiter(rest);
				p.setMessage("��ӳɹ���");
			}catch(Exception e){
				e.printStackTrace();
			}
					
			return p; 	
		}
		
		@RequestMapping("/delReastWaiter")
		@ResponseBody
		public PageView delReast(Integer id){
			PageView p=new PageView();
			try{
				perService.delReastWaiter(id);
			}catch(Exception e){
				e.printStackTrace();
			}
			p.setMessage("ɾ���ɹ�");
			return p;
		}
		
		
		
		@RequestMapping("/selectGaraWaiter")
		@ResponseBody
		public PageView getListGara(int rows,int page){
			//��ѯList
			List<GarageWatierInfo> list=perService.getListGaraWaiter(page,rows);
			//��ѯ������
			int total=perService.queryGara();
			PageView pa=new PageView();
			pa.setRows(list);
			pa.setTotal(total);
			return pa;
		}
		
		@RequestMapping("/addGaraWaiter")
		@ResponseBody
		public PageView addGara(GarageWatierInfo ga){
			PageView p=new PageView();
			try{	
				perService.addGaraWaiter(ga);
				p.setMessage("��ӳɹ���");
			}catch(Exception e){
				e.printStackTrace();
			}
					
			return p; 	
		}
		
		@RequestMapping("/delGaraWaiter")
		@ResponseBody
		public PageView delGara(Integer id){
			PageView p=new PageView();
			try{
				perService.delGaraWaiter(id);
			}catch(Exception e){
				e.printStackTrace();
			}
			p.setMessage("ɾ���ɹ�");
			return p;
		}
}
