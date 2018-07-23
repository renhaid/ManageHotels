package com.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.GarageWatierInfo;
import com.pojo.RestWaiterInfo;
import com.pojo.RoomInfo;
import com.pojo.RoomWaiterInfo;

@Repository
public interface PersonManageDao {

	List<RoomWaiterInfo> list(Map map);

	int query();

	void add(RoomWaiterInfo room);

	void del(int data_id);

	java.util.List<RestWaiterInfo> listReast(Map map);

	int getQuery();

	void addReat(RestWaiterInfo rest);

	void deleteReat(int data_id);

	java.util.List<GarageWatierInfo> listGara(Map map);

	int getQueryGara();

	void addGara(GarageWatierInfo ga);

	void deleteGara(int data_id);

}
