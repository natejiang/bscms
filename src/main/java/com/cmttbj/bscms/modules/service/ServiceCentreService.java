package com.cmttbj.bscms.modules.service;

import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;

public interface ServiceCentreService {
	/**
	 * @author Jiangnan 
	 * @date 2017-04-10
	 * @param serviceCentre
	 * @return
	 */
	int addServiceCentre(ServiceCentre serviceCentre);
	List<ServiceCentre> findServiceCentreById(Integer serviceCentre_id);
	List<ServiceCentre> findAll();
}
