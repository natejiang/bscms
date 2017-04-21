package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.CustomerDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.Customer;

public class CustomerDaoHibernate4 extends BaseDaoHibernate4<Customer>
	implements CustomerDao{

	/**
	 * @author Jiangnan
	 * @since 2017-04-08
	 */

	@Override
	public List<Customer> findAllOrderById(Class<Customer> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}
	
	@Override
	public List<Customer> findByPageOrderById(Class<Customer> entityClazz,
			int pageNo, int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);	
	}

	@Override
	public List<Customer> findByDateAndServiceCentreId(Class<Customer> entityClazz, Date date, ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date = ? and en.serviceCentre = ?", date, serviceCentre);
	}

	@Override
	public List<Customer> findByDatesAndServiceCentre(Class<Customer> entityClazz, Date begin,
			Date end, ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ? and en.serviceCentre = ?", begin, end, serviceCentre);
	}


}
