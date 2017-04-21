package com.cmttbj.bscms.modules.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public interface RenewBroadbandService {
	/**
	 * @author Jiangnan
	 * @date 2017-04-13
	 */
	List<RenewBroadband> searchRenewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);

}
