package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.DoorToDoorDao;
import com.cmttbj.bscms.modules.entity.DoorToDoor;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public class DoorToDoorDaoHibernate4 extends BaseDaoHibernate4<DoorToDoor>
	implements DoorToDoorDao{
	
	private SessionFactory sessionFactory;	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<DoorToDoor> findAllOrderById(Class<DoorToDoor> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<DoorToDoor> findByPageOrderById(Class<DoorToDoor> entityClazz, int pageNo, int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> sumByDatesAndServiceCentre(Class<DoorToDoor> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre){
		return sessionFactory.getCurrentSession().createQuery("select sum(en.installedQuantity),sum(en.repairedQuantity) from " + entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1 and en.serviceCentre = ?2" 
				+ " order by en.date desc")
			.setParameter("0", end)
			.setParameter("1", begin)
			.setParameter("2", serviceCentre)
			.list();
	}

	@Override
	public List<DoorToDoor> findByDatesAndServiceCentre(Class<DoorToDoor> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ? and en.serviceCentre = ?"
				+ " order by en.date desc", 
				end, begin, serviceCentre);
	}

	@Override
	public List<DoorToDoor> findByDates(Class<DoorToDoor> entityClazz, Date end, Date begin) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.date between ? and ?"
				+ " order by en.date desc", 
				end, begin);
	}

	@Override
	public List<DoorToDoor> findByDatesAndCompany(Class<DoorToDoor> entityClazz, Date end, Date begin, String company) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> sumByDates(Class<DoorToDoor> entityClazz, Date end, Date begin) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.installedQuantity),sum(en.repairedQuantity) from " 
				+ entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1" 
				+ " order by en.date desc")
			.setParameter("0", end)
			.setParameter("1", begin)
			.list();
	}
}
