package com.cmttbj.bscms.modules.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.DoorToDoor;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
/**
 * @author Jiangnan
 * @date 2017-04-13
 */
public interface DoorToDoorService {

	List<DoorToDoor> searchDoorToDoorByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	
	List<Object> sumDoorToDoorByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	
}
