package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PersonManageDao;
import com.pojo.GarageWatierInfo;
import com.pojo.RestWaiterInfo;
import com.pojo.RoomInfo;
import com.pojo.RoomWaiterInfo;

@Service
public class PersonSerivce {
	@Autowired
	private PersonManageDao perDao;

	public List<RoomWaiterInfo> getList(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return perDao.list(map);
	}

	public int queryCount() {
		return perDao.query();
	}

	public void addRoom(RoomWaiterInfo room) {
		perDao.add(room);
		
	}

	public void delete(Integer id) {
		int data_id=id;
		perDao.del(data_id);
		
	}

	public List<RestWaiterInfo> List(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return perDao.listReast(map);
	}

	public int query() {
		return perDao.getQuery();
	}

	public void addReastWaiter(RestWaiterInfo rest) {
		perDao.addReat(rest);
	}

	public void delReastWaiter(Integer id) {
		int data_id=id;
		perDao.deleteReat(data_id);
		
	}

	public List<GarageWatierInfo> getListGaraWaiter(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return perDao.listGara(map);
	}

	public int queryGara() {
		return perDao.getQueryGara();
	}

	public void addGaraWaiter(GarageWatierInfo ga) {
		perDao.addGara(ga);
		
	}

	public void delGaraWaiter(Integer id) {
		int data_id=id;
		perDao.deleteGara(data_id);	
	}

}
