package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.GarageDao;
import com.pojo.GaraCheckInfo;
import com.pojo.GarageInfo;
import com.pojo.GarageWatierInfo;

@Service
public class GarageService {
	@Autowired
      private GarageDao garaDao;

	public List<GarageInfo> getList(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return garaDao.list(map);
	}

	public int queryCount() {
		return garaDao.query();
	}

	public List<GarageWatierInfo> getId(GarageWatierInfo ga) {
		Map map=new HashMap();
		map.put("status", ga.getStatus());
		return garaDao.getGaraWaiter(map);
	}

	public void add(GaraCheckInfo ga) {
		garaDao.insertGara(ga);
		
	}

	public GarageInfo findGarage() {
		// TODO Auto-generated method stub
		return garaDao.getFind();
	}

	public void up(int i) {
		Map map=new HashMap();
		map.put("count",i);
		garaDao.upGarage(map);
		
	}

	public List<GaraCheckInfo> getLi(int page, int rows) {
		Map map=new HashMap();
		map.put("rows", rows);
		map.put("page", (page-1)*rows);
		return garaDao.getCheckInfo(map);
	}

	public int query() {
		// TODO Auto-generated method stub
		return garaDao.getQuery();
	}

	public void upGarageCheckInfo(Integer id, String garaEndDate) {
		Map map=new HashMap();
		map.put("id", id);
		map.put("garaEndDate", garaEndDate);
		map.put("remark", "Ω· ¯ π”√");
		garaDao.upGarageCheck(map);
		
	}

	public void upGaraInfo(int i) {
		Map map=new HashMap();
		map.put("count",i);
		garaDao.upGaraIn(map);
		
	}
}
