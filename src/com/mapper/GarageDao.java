package com.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.GaraCheckInfo;
import com.pojo.GarageInfo;
import com.pojo.GarageWatierInfo;

@Repository
public interface GarageDao {

	List<GarageInfo> list(Map map);

	int query();

	List<GarageWatierInfo> getGaraWaiter(Map map);

	void insertGara(GaraCheckInfo ga);

	GarageInfo getFind();

	void upGarage(Map map);

	List<GaraCheckInfo> getCheckInfo(Map map);

	int getQuery();

	void upGarageCheck(Map map);

	void upGaraIn(Map map);

}
