package com.cmttbj.bscms.modules.dao.impl;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.ServiceCentreDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public class ServiceCentreDaoHibernate4 extends BaseDaoHibernate4<ServiceCentre>
	implements ServiceCentreDao{

	@Override
	public List<ServiceCentre> findAllOrderById(Class<ServiceCentre> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<ServiceCentre> findByPageOrderById(Class<ServiceCentre> entityClazz, int pageNo, int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);
	}

	@Override
	public List<ServiceCentre> findById(Class<ServiceCentre> entityClazz, Integer serviceCentreId) {
		System.out.println(serviceCentreId);
		return find("select en from " + entityClazz.getSimpleName() + " en where en.serviceCentreId = ?", serviceCentreId);
	}

	@Override
	public List<ServiceCentre> findAll() {		
		return find("select s from ServiceCentre s order by s.id desc");
	}
}
