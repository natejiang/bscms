package com.cmttbj.bscms.modules.service.impl;

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

}
