package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.dao.RenewBroadbandDao;
import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public class RenewBroadbandDaoHibernate4 extends BaseDaoHibernate4<RenewBroadband>
	implements RenewBroadbandDao,DailyReportCommonDao<RenewBroadband>{

	@Override
	public List<RenewBroadband> findAllOrderById(Class<RenewBroadband> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<RenewBroadband> findByPageOrderById(Class<RenewBroadband> entityClazz, int pageNo, int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);	
	}

	@Override
	public List<RenewBroadband> findByDatesAndServiceCentre(Class<RenewBroadband> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ? and en.serviceCentre = ?"
				+ " order by en.date desc", 
				end, begin, serviceCentre);
	}

	@Override
	public List<RenewBroadband> findByDates(Class<RenewBroadband> entityClazz, Date end, Date begin) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ?"
				+ " order by en.date desc", 
				end, begin);
	}

	@Override
	public List<RenewBroadband> findByDatesAndCompany(Class<RenewBroadband> entityClazz, Date end, Date begin,
			String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> sumByDatesAndServiceCentre(Class<RenewBroadband> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		// TODO Auto-generated method stub
		return null;
	}



}
