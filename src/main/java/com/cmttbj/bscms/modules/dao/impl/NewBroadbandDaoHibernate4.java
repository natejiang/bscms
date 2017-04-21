package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.NewBroadbandDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.NewBroadband;

public class NewBroadbandDaoHibernate4 extends BaseDaoHibernate4<NewBroadband>
	implements NewBroadbandDao{
	
	private SessionFactory sessionFactory;	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<NewBroadband> findAllOrderById(Class<NewBroadband> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<NewBroadband> findByPageOrderById(Class<NewBroadband> entityClazz, int pageNo, int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);	
	}
	//获取实体按日期和服务中心
	@Override
	public List<NewBroadband> findByDatesAndServiceCentre(Class<NewBroadband> entityClazz,
			Date begin, Date end, ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ? and en.serviceCentre = ?"
				+ " order by en.date desc", 
				end, begin, serviceCentre);
	}
	//获取实体按日期
	@Override
	public List<NewBroadband> findByDates(Class<NewBroadband> entityClazz,
			Date begin, Date end) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ?"
				+ " order by en.date desc", 
				end, begin);
	}

	@Override
	public List<NewBroadband> findByDatesAndCompany(Class<NewBroadband> entityClazz, Date end, Date begin,
			String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object> sumByDatesAndServiceCentre(Class<NewBroadband> entityClazz, Date end, Date begin,
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
}
