package com.cmttbj.bscms.modules.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.dao.RenewBroadbandDao;
import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.RenewBroadbandService;

public class RenewBroadbandServiceImpl implements RenewBroadbandService {
	private RenewBroadbandDao renewBroadbandDao;
	
	public RenewBroadbandDao getRenewBroadbandDao() {
		return renewBroadbandDao;
	}

	public void setRenewBroadbandDao(RenewBroadbandDao renewBroadbandDao) {
		this.renewBroadbandDao = renewBroadbandDao;
	}

	@Override
	public List<RenewBroadband> searchByDatesAndServiceCentre(Date end, Date begin,
			ServiceCentre serviceCentre) {
		
		return (List<RenewBroadband>) renewBroadbandDao
				.findByDatesAndServiceCentre(RenewBroadband.class, end, begin, serviceCentre);
	}

	@Override
	public List<RenewBroadband> searchByDates(Date end, Date begin) {
		List<RenewBroadband> list = renewBroadbandDao.findByDates(RenewBroadband.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> objsList = renewBroadbandDao.sumByDatesAndServiceCentre(RenewBroadband.class, end, begin, serviceCentre);
		Object[] objs = (Object[]) objsList.get(0);
		List<String> list = new ArrayList<>();
		for(int i = 0;i < objs.length; i ++)
		{
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}
		}
		return list;
	}

	@Override
	public List<String> sumByDates(Date end, Date begin) {
		List<String> list = new ArrayList<String>() ;
		List<Object> objsList = renewBroadbandDao.sumByDates(RenewBroadband.class, end, begin);	
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
	public List<RenewBroadband> searchByDatesAndCompany(Date end, Date begin, String company) {
		List<RenewBroadband> list = renewBroadbandDao
				.findByDatesAndCompany(RenewBroadband.class, end, begin, company);
		return list;
	}

	@Override
	public List<String> sumByDatesAndCompany(Date end, Date begin, String company) {
		List<String> list = new ArrayList<String>() ;
		List<Object> objsList = renewBroadbandDao
				.sumByDatesAndCompany(RenewBroadband.class, end, begin, company);	
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
