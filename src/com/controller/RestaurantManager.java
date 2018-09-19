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
 * @author ��������
 *
 */
@Controller
public class RestaurantManager {
	@Autowired
	private ReasturantService restService;
	
	/**
	 * 
	 * @param rows ����
	 * @param page ҳ��
	 * @return
	 */
	@RequestMapping("/selectSeatInfo")
	@ResponseBody
	public PageView getList(int rows,int page){
		//��ѯList
				List<RoomInfo> list=restService.getList(page,rows);
				//��ѯ������
				int total=restService.queryCount();		
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
	@RequestMapping("/delSeatInfo")
	@ResponseBody
	public PageView del(Integer id){
		PageView p=new PageView();
		try{
			restService.delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		p.setMessage("ɾ���ɹ�");
		return p;
	}
	
	/**
	 * 
	 * @param ��Ӳ�����Ϣ
	 * @return
	 */
	@RequestMapping("addSeatInfo.do")
	@ResponseBody
	public PageView add(SeatInfo seat){
		PageView p=new PageView();
		try{	
			restService.addSeat(seat);
			p.setMessage("��ӳɹ���");
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return p; 
		
	}
	
	
	/**
	 * ��ѯ���е���λ���
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
	 * ��ѯ���еĽӴ���Ա���
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
	 * @return ��ѯ��ǰ�Ƶ�˿�Id
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
	 * @param ��ӹ˿��ò���Ϣ
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
	 * @return  ��ʾ��ǰ�˿͵��ò���Ϣ
	 */
	@RequestMapping("/selectReastCustInfo")
	@ResponseBody
	public PageView getSelectReastCust(int rows,int page){
		//��ѯList
				List<RestCustInfo> listStay=restService.getReastCust(rows,page);
				//��ѯ������
				int total=restService.queryReast();	
				PageView pa=new PageView();
				pa.setRows(listStay);
				pa.setTotal(total);
				return pa;		
	}
	
	/**
	 * 
	 * @return �����ò�
	 */
	@RequestMapping("/endServlet")
	@ResponseBody
	public PageView end(Integer id){
		PageView pa=new PageView();
		restService.endReast(id);
		RestCustInfo res=restService.getRest(id);
		restService.updateSeatInfo(res.getSeatId());
		pa.setMessage("�òͽ�����");
		return pa;
	}
	
		
		
}
