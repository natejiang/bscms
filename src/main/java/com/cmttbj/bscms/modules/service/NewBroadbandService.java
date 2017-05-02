package com.cmttbj.bscms.modules.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.NewBroadband;

public interface NewBroadbandService {
	/**
	 * NewBroadband服务类
	 * @author Jiangnan
	 * @date 2017-04-13
	 */
	List<NewBroadband> searchNewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	List<NewBroadband> searchNewBroadbandBydates(Date end, Date begin);
	List<String> sumNewBroadbandByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	//求和实体属性根据日期
	List<String> sumNewBroadbandByDates(Date end, Date begin);
}
