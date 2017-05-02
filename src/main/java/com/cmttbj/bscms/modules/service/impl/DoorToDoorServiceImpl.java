package com.cmttbj.bscms.modules.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.dao.DoorToDoorDao;
import com.cmttbj.bscms.modules.entity.DoorToDoor;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.DoorToDoorService;

public class DoorToDoorServiceImpl implements DoorToDoorService{
	private DoorToDoorDao doorToDoorDao;
	
	public DoorToDoorDao getDoorToDoorDao() {
		return doorToDoorDao;
	}

	public void setDoorToDoorDao(DoorToDoorDao doorToDoorDao) {
		this.doorToDoorDao = doorToDoorDao;
	}

	@Override
	public List<DoorToDoor> searchDoorToDoorByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<DoorToDoor> list = doorToDoorDao.findByDatesAndServiceCentre(DoorToDoor.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<Object> sumDoorToDoorByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> list = doorToDoorDao.sumByDatesAndServiceCentre(DoorToDoor.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<DoorToDoor> searchDoorToDoorByDates(Date end, Date begin) {
		List<DoorToDoor> list = doorToDoorDao.findByDates(DoorToDoor.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumDoorToDoorByDates(Date end, Date begin) {
		List<Object> objsList = doorToDoorDao.sumByDates(DoorToDoor.class, end, begin);
		Object[] objs = (Object[]) objsList.get(0);
		List<String> list = new ArrayList<>();
		for(int i = 0;i < objs.length;i ++){
			list.add(i, objs[i].toString());
		}		
		return list;
	}

}
