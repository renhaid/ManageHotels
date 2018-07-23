package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ReasturantDao;
import com.pojo.RestCustInfo;
import com.pojo.RestWaiterInfo;
import com.pojo.RoomInfo;
import com.pojo.SeatInfo;
import com.pojo.StayInfo;

@Service
public class ReasturantService {
	@Autowired
	private ReasturantDao restDao;

	public List<RoomInfo> getList(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return restDao.list(map);
	}

	public int queryCount() {
		return restDao.query();
	}

	public void delete(Integer id) {
		int data_id=id;
		restDao.del(data_id);
	}

	public void addSeat(SeatInfo seat) {
		restDao.add(seat);
		
	}

	public List<SeatInfo> getSeatId(SeatInfo seat) {
			return restDao.getList(seat);
	}

	public List<RestWaiterInfo> getRecId(RestWaiterInfo res) {
		Map map=new HashMap();
		map.put("status", res.getStatus());
		return restDao.getRecId(map);
	}

	public List<StayInfo> getCustId(StayInfo stay) {
		Map map=new HashMap();
		map.put("remark", stay.getRemark());
		return restDao.getCustId(map);
	}

	public void insert(RestCustInfo rst) {
		restDao.ins(rst);
		
	}

	public void upSeat(int seatId) {
		Map map=new HashMap<>();
		map.put("seatId", seatId);
		map.put("seatSatus", "有客");
		restDao.upda(map);
		
	}

	public List<RestCustInfo> getReastCust(int rows, int page) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return restDao.getReastCustInfo(map);
	}

	public int queryReast() {
		return restDao.queryFind();
	}

	public void endReast(Integer id) {
		Map map=new HashMap<>();
		map.put("id", id);
		map.put("remark", "结束用餐");
		restDao.endRea(map);
		
	}

	public RestCustInfo getRest(Integer id) {
		int data_id=id;
		return restDao.getRestCust(data_id);
	}

	public void updateSeatInfo(int seatId) {
		Map map=new HashMap<>();
		map.put("seatId", seatId);
		map.put("seatSatus", "空闲");
		restDao.updateSeat(map);
		
	}

	

}
