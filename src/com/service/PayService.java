package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.PayDao;
import com.pojo.GaraCheckInfo;
import com.pojo.RestCustInfo;
import com.pojo.RoomInfo;
import com.pojo.StayInfo;

@Service
public class PayService {
		@Autowired
		private PayDao payDao;

		public StayInfo select(StayInfo stay) {
			// TODO Auto-generated method stub
			return payDao.getStayInfo(stay);
		}

		public RoomInfo selectRoom(int roomId) {
			Map map=new HashMap<>();
			map.put("roomId", roomId);
			return payDao.getRoom(map);
		}

		public RestCustInfo selectReastInfo(RestCustInfo rest) {
			return payDao.getRestCustInfo(rest);
		}

		public GaraCheckInfo getGaraPayInfo(GaraCheckInfo ga) {
			return payDao.getGagage(ga);
		}
}
