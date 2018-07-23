package com.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.RoomInfo;
import com.pojo.StayInfo;

@Repository
public interface RoomDao {

	List<RoomInfo> list(Map map);

	int query();

	void del(int data_id);

	void add(RoomInfo roomInfo);

	List<RoomInfo> getList(Map map);

	void ins(StayInfo stay);

	void update(Map map);

	List<StayInfo> li(Map map);

	int findStay();

	void liv(Map map);

	StayInfo findStayInfo(int roomId);

	void upRoomInfo(Map map);

	


}
