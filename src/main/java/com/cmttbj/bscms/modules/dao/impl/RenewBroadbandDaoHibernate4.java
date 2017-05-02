package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.dao.RenewBroadbandDao;
import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public class RenewBroadbandDaoHibernate4 extends BaseDaoHibernate4<RenewBroadband>
	implements RenewBroadbandDao,DailyReportCommonDao<RenewBroadband>{
private SessionFactory sessionFactory;	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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

	@SuppressWarnings("unchecked")
	public List<Object> sumByDatesAndServiceCentre(Class<RenewBroadband> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.ihomeBroadbandQuantity20)"
				+ ",sum(en.ihomeBroadbandQuantity30)"
				+ ",sum(en.ihomeBroadbandQuantity50)"
				+ ",sum(en.ihomeBroadbandQuantity100)"
				+ ",sum(en.onlyBroadbandQuantity20)"
				+ ",sum(en.onlyBroadbandQuantity30)"
				+ ",sum(en.onlyBroadbandQuantity50)"
				+ ",sum(en.onlyBroadbandQuantity100) from " + entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1 and en.serviceCentre = ?2" 
				+ " order by en.date desc")
				.setParameter("0", end)
				.setParameter("1", begin)
				.setParameter("2", serviceCentre)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> sumByDates(Class<RenewBroadband> entityClazz, Date end, Date begin) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.ihomeBroadbandQuantity20)"
				+ ",sum(en.ihomeBroadbandQuantity30)"
				+ ",sum(en.ihomeBroadbandQuantity50)"
				+ ",sum(en.ihomeBroadbandQuantity100)"
				+ ",sum(en.onlyBroadbandQuantity20)"
				+ ",sum(en.onlyBroadbandQuantity30)"
				+ ",sum(en.onlyBroadbandQuantity50)"
				+ ",sum(en.onlyBroadbandQuantity100) from " + entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1" 
				+ " order by en.date desc")
				.setParameter("0", end)
				.setParameter("1", begin)
				.list();
	}
}
