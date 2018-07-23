package com.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.RestCustInfo;
import com.pojo.RestWaiterInfo;
import com.pojo.RoomInfo;
import com.pojo.SeatInfo;
import com.pojo.StayInfo;

@Repository
public interface ReasturantDao {

	List<RoomInfo> list(Map map);

	int query();

	void del(int data_id);

	void add(SeatInfo seat);

	List<SeatInfo> getList(SeatInfo seat);

	List<RestWaiterInfo> getRecId(Map map);

	List<StayInfo> getCustId(Map map);

	void ins(RestCustInfo rst);

	void upda(Map map);

	List<RestCustInfo> getReastCustInfo(Map map);

	int queryFind();

	void endRea(Map map);

	RestCustInfo getRestCust(int data_id);

	void updateSeat(Map map);

}
