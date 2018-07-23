package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RoomDao;
import com.pojo.RoomInfo;
import com.pojo.StayInfo;

@Service
public class RoomService {
	@Autowired
	private RoomDao roomDao;

	public List<RoomInfo> getList(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return roomDao.list(map);
	}

	public int queryCount() {
		
		return roomDao.query();
	}

	public void delete(Integer id) {
		int data_id=id;
		roomDao.del(data_id);
	}

	public void addRoom(RoomInfo roomInfo) {
		roomDao.add(roomInfo);
		
	}

	public List<RoomInfo> list(String str) {
		Map map=new HashMap();
		map.put("status", str);
		List<RoomInfo> li=roomDao.getList(map);
		return li;
	}

	public void insert(StayInfo stay) {
		roomDao.ins(stay);
		
	}

	public void upRoom(int roomId) {
		Map map=new HashMap();
		map.put("roomId", roomId);
		map.put("status", "住人");
		roomDao.update(map);
		
	}

	public List<StayInfo> getListStay(int rows, int page) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return roomDao.li(map);
	}

	public int query() {
		return roomDao.findStay();
	}

	public void live(Integer id,String out) {
		Map map=new HashMap();
		map.put("id", id);
		map.put("remark", "已退房");
		map.put("outDate", out);
		roomDao.liv(map);
		
	}

	public StayInfo findRoomId(Integer id) {
		int roomId=id;
		return roomDao.findStayInfo(roomId);
	}

	public void up(int roomId) {
		Map map=new HashMap();
		map.put("roomId", roomId);
		map.put("status","空房");
		roomDao.upRoomInfo(map);
		
	}

}
