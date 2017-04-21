package com.cmttbj.bscms.modules.service.impl;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> sumDoorToDoorByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> list = doorToDoorDao.sumByDatesAndServiceCentre(DoorToDoor.class, end, begin, serviceCentre);
		System.out.println(list.toString());
		return list;
	}

}
