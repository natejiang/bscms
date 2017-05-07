package com.cmttbj.bscms.modules.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.dao.NewBroadbandDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.NewBroadband;
import com.cmttbj.bscms.modules.service.NewBroadbandService;

public class NewBroadbandServiceImpl implements NewBroadbandService{
	private NewBroadbandDao newBroadbandDao;

	public NewBroadbandDao getNewBroadbandDao() {
		return newBroadbandDao;
	}

	public void setNewBroadbandDao(NewBroadbandDao newBroadbandDao) {
		this.newBroadbandDao = newBroadbandDao;
	}

	@Override
	public List<NewBroadband> searchByDatesAndServiceCentre(Date begin, Date end,
			ServiceCentre serviceCentre) {
		List<NewBroadband> list = newBroadbandDao
				.findByDatesAndServiceCentre(NewBroadband.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> objsList = newBroadbandDao
				.sumByDatesAndServiceCentre(NewBroadband.class, end, begin, serviceCentre);
		Object[] objs = (Object[]) objsList.get(0);
		List<String> list = new ArrayList<>();
		for(int i = 0;i < objs.length;i ++){
			list.add(i, objs[i].toString());
		}
		return list;
	}
	
	@Override
	public List<NewBroadband> searchByDates(Date end, Date begin) {
		List<NewBroadband> list = newBroadbandDao.findByDates(NewBroadband.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumByDates(Date end, Date begin) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = newBroadbandDao.sumByDates(NewBroadband.class, end, begin);
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
	public List<NewBroadband> searchByDatesAndCompany(Date end, Date begin, String company) {
		List<NewBroadband> list = newBroadbandDao.findByDatesAndCompany(NewBroadband.class, end, begin, company);
		return list;
	}

	@Override
	public List<String> sumByDatesAndCompany(Date end, Date begin, String company) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = newBroadbandDao.sumByDatesAndCompany(NewBroadband.class, end, begin, company);
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
