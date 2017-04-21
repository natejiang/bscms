package com.cmttbj.bscms.modules.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.NewBroadband;

public interface NewBroadbandService {
	/**
	 * @author Jiangnan
	 * @date 2017-04-13
	 */
	List<NewBroadband> searchNewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	
	List<Object> sumNewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
}
