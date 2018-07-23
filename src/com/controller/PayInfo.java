package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.GaraCheckInfo;
import com.pojo.PageView;
import com.pojo.RestCustInfo;
import com.pojo.RoomInfo;
import com.pojo.StayInfo;
import com.service.PayService;
import com.vo.PlayShow;

@Controller
public class PayInfo {
	@Autowired
	private PayService payService;
	
	@RequestMapping("/queryRoomPayInfo")
	@ResponseBody
	public PlayShow getPlay(StayInfo stay,HttpServletRequest req){
		PlayShow pl=new PlayShow();
		PageView p=new PageView();
		//查询日期
		StayInfo st=payService.select(stay);
		if(st!=null){	
			RoomInfo rs=payService.selectRoom(st.getRoomId());
			if(rs!=null){
				try{
					int day=PayInfo.getDay(st.getOutDate(), st.getCheckDate());
					if(day>0){
						double money=rs.getRoomPrice()*day;
						pl.setMoney(money);
					}else {
						double money=rs.getRoomPrice()*1;
						pl.setMoney(money);
					}
					pl.setCustName(st.getCustName());
					pl.setStartDate(st.getCheckDate());
					pl.setRoomId(st.getRoomId());
					pl.setEndDate(st.getOutDate());
/*					HttpSession session=req.getSession();
					session.setAttribute("playshow", pl);*/
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return pl;
	}
	
	
	@RequestMapping("/queryReastPayInfo")
	@ResponseBody
	public PlayShow getPlayReast(RestCustInfo rest){
		PlayShow pl=new PlayShow();
		RestCustInfo re=payService.selectReastInfo(rest);
		if(re!=null){
			pl.setCustName(re.getCustName());
			pl.setSeatId(re.getSeatId());
			pl.setMoney(re.getPrice());
		}
		
		
		return pl;
	}

	
	@RequestMapping("/queryGaraPayInfo")
	@ResponseBody
	public PlayShow getGaraPay(GaraCheckInfo ga){
		PlayShow pl=new PlayShow();
		GaraCheckInfo g=payService.getGaraPayInfo(ga);
		if(g!=null){
			try {
				int day=PayInfo.getDay(g.getGaraEndDate(), g.getGaraDate());
				if(day>0){
					double money =day*150;
					pl.setMoney(money);
				}else {
					double money=150;
					pl.setMoney(money);
				}
				pl.setCustName(g.getGaraUseName());
				pl.setStartDate(g.getGaraDate());
				pl.setEndDate(g.getGaraEndDate());
				pl.setGaraId(g.getGaraId());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		return pl;
		
	}
	
	
	
	//比较两个日期相差多少天
	public  static int getDay(String str1,String str2) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(str1);
		Date date2 = format.parse(str2);
		int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));		
		return a;
	}
}
