package com.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.GaraCheckInfo;
import com.pojo.RestCustInfo;
import com.pojo.RoomInfo;
import com.pojo.StayInfo;

@Repository
public interface PayDao {

	StayInfo getStayInfo(StayInfo stay);

	RoomInfo getRoom(Map map);

	RestCustInfo getRestCustInfo(RestCustInfo rest);

	GaraCheckInfo getGagage(GaraCheckInfo ga);

}
