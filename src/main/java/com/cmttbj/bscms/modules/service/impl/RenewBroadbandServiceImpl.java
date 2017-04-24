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
	public List<RenewBroadband> searchRenewBroadbandByDatesAndServiceCentre(Date end, Date begin,
			ServiceCentre serviceCentre) {
		
		return (List<RenewBroadband>) renewBroadbandDao
				.findByDatesAndServiceCentre(RenewBroadband.class, end, begin, serviceCentre);
	}

	@Override
	public List<RenewBroadband> searchRenewBroadbandBydates(Date end, Date begin) {
		List<RenewBroadband> list = renewBroadbandDao.findByDates(RenewBroadband.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumRenewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> objsList = renewBroadbandDao.sumByDatesAndServiceCentre(RenewBroadband.class, end, begin, serviceCentre);
		Object[] objs = (Object[]) objsList.get(0);
		List<String> list = new ArrayList<>();
		for(int i = 0;i < objs.length; i ++)
		{
			list.add(i, objs[i].toString());
		}
		return list;
	}

	@Override
	public List<String> sumRenewBroadbandByDates(Date end, Date begin) {
		List<Object> objsList = renewBroadbandDao.sumByDates(RenewBroadband.class, end, begin);
		Object[] objs = (Object[]) objsList.get(0);
		List<String> list = new ArrayList<String>() ;
		for(int i = 0;i < objs.length; i ++)
		{
			list.add(i, objs[i].toString());
		}
		return list;
	}

}
