package com.cmttbj.bscms.modules.service.impl;

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
	public List<NewBroadband> searchNewBroadbandByDatesAndServiceCentre(Date begin, Date end,
			ServiceCentre serviceCentre) {
		List<NewBroadband> list = newBroadbandDao
				.findByDatesAndServiceCentre(NewBroadband.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<Object> sumNewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> list = newBroadbandDao.sumByDatesAndServiceCentre(NewBroadband.class, end, begin, serviceCentre);
		return list;
	}

}
