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
	public List<DoorToDoor> searchByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<DoorToDoor> list = doorToDoorDao.findByDatesAndServiceCentre(DoorToDoor.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = doorToDoorDao.sumByDatesAndServiceCentre(DoorToDoor.class, end, begin, serviceCentre);
		Object[] objs = (Object[]) objsList.get(0);
		for (int i = 0; i < objs.length; i ++){
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}			
		}	
		return list;	
	}

	@Override
	public List<DoorToDoor> searchByDates(Date end, Date begin) {
		List<DoorToDoor> list = doorToDoorDao.findByDates(DoorToDoor.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumByDates(Date end, Date begin) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = doorToDoorDao.sumByDates(DoorToDoor.class, end, begin);
		Object[] objs = (Object[]) objsList.get(0);
		for (int i = 0; i < objs.length; i ++){
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}			
		}	
		return list;	
	}

	@Override
	public List<DoorToDoor> searchByDatesAndCompany(Date end, Date begin, String company) {
		List<DoorToDoor> list = doorToDoorDao.findByDatesAndCompany(DoorToDoor.class, end, begin, company);
		return list;
	}

	@Override
	public List<String> sumByDatesAndCompany(Date end, Date begin, String company) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = doorToDoorDao.sumByDatesAndCompany(DoorToDoor.class, end, begin, company);
		Object[] objs = (Object[]) objsList.get(0);
		for (int i = 0; i < objs.length; i ++){
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}			
		}	
		return list;
	}

}
