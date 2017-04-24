package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.MobileProductDao;
import com.cmttbj.bscms.modules.entity.MobileProduct;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public class MobileProductDaoHibernate4 extends BaseDaoHibernate4<MobileProduct> 
	implements MobileProductDao{
	
	private SessionFactory sessionFactory;	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<MobileProduct> findAllOrderById(Class<MobileProduct> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<MobileProduct> findByPageOrderById(Class<MobileProduct> entityClazz, int pageNo,
			int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);
	}

	@Override
	public List<MobileProduct> findByDatesAndServiceCentre(Class<MobileProduct> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() 
			+ " en where en.date between ? and ? and en.serviceCentre = ?"
			+ " order by en.date desc", end, begin, serviceCentre);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> sumByDatesAndServiceCentre(Class<MobileProduct> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.simQuantity)"				
				+ ",sum(en.terminalQuantity)"
				+ ",sum(en.televisionQuantity) from " + entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1 and en.serviceCentre = ?2" 
				+ " order by en.date desc")
				.setParameter("0", end)
				.setParameter("1", begin)
				.setParameter("2", serviceCentre)
				.list();
	}

	@Override
	public List<MobileProduct> findByDatesAndCompany(Class<MobileProduct> entityClazz, Date end, Date begin,
			String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MobileProduct> findByDates(Class<MobileProduct> entityClazz, Date end, Date begin) {
		return find("select en from " + entityClazz.getSimpleName() 
		+ " en where en.date between ? and ?"
		+ " order by en.date desc", end, begin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> sumByDates(Class<MobileProduct> entityClazz, Date end, Date begin) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.simQuantity)"				
				+ ",sum(en.terminalQuantity)"
				+ ",sum(en.televisionQuantity) from " + entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1" 
				+ " order by en.date desc")
			.setParameter("0", end)
			.setParameter("1", begin)
			.list();
	}

}
