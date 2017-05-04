package com.cmttbj.bscms.modules.service.impl;

import java.util.List;

import com.cmttbj.bscms.modules.dao.ServiceCentreDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.ServiceCentreService;

public class ServiceCentreServiceImpl implements ServiceCentreService {
	private ServiceCentreDao serviceCentreDao;
	
	public ServiceCentreDao getServiceCentreDao() {
		return serviceCentreDao;
	}

	public void setServiceCentreDao(ServiceCentreDao serviceCentreDao) {
		this.serviceCentreDao = serviceCentreDao;
	}

	@Override
	public int addServiceCentre(ServiceCentre serviceCentre) {
		serviceCentreDao.save(serviceCentre);	
		return 0;
	}

	@Override
	public List<ServiceCentre> findServiceCentreById(Integer serviceCentre_id) {
		System.out.println(serviceCentre_id);
		List<ServiceCentre> list = serviceCentreDao.findById(ServiceCentre.class, serviceCentre_id);
		return list;
	}

	@Override
	public List<ServiceCentre> findAll() {
		List<ServiceCentre> list = serviceCentreDao.findAll();
		for (int i = 0;i < list.size();i ++)
		{
			System.out.println(list.get(i).getServiceCentreId() + list.get(i).getServiceCentreName());
		}
		return list;
	}


}
