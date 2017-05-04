package com.cmttbj.bscms.modules.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.CustomerDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.Customer;
/**
 * @author Jiangnan
 * @since 2017-04-24
 */
public class CustomerDaoHibernate4 extends BaseDaoHibernate4<Customer>
	implements CustomerDao{

	private SessionFactory sessionFactory;	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
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
		return find("select en from " + entityClazz.getSimpleName() 
			+ " en where en.date = ? and en.serviceCentre = ?", date, serviceCentre);
	}

	@Override
	public List<Customer> findByDatesAndServiceCentre(Class<Customer> entityClazz, Date end,
			Date begin, ServiceCentre serviceCentre) {
		return find("select en from " + entityClazz.getSimpleName() 
			+ " en where en.date between ? and ? and en.serviceCentre = ?"
			+ " order by en.date desc", end, begin, serviceCentre);
	}

	@SuppressWarnings("unchecked")
	public List<Object> sumByDatesAndServiceCentre(Class<Customer> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.customerQuantity) from " 
				+ entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1 and en.serviceCentre = ?2" 
				+ " order by en.date desc")
				.setParameter("0", end)
				.setParameter("1", begin)
				.setParameter("2", serviceCentre)
				.list();
	}		

	@Override
	public List<Customer> findByDatesAndCompany(Class<Customer> entityClazz, Date end, Date begin, String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByDates(Class<Customer> entityClazz, Date end, Date begin) {
		return find("select en from " + entityClazz.getSimpleName() 
			+ " en where en.date between ? and ?" + " order by en.date desc", end, begin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> sumByDates(Class<Customer> entityClazz, Date end, Date begin) {
		return sessionFactory.getCurrentSession().createQuery("select sum(en.customerQuantity) from " 
				+ entityClazz.getSimpleName() 
				+ " en where en.date between ?0 and ?1" 
				+ " order by en.date desc")
				.setParameter("0", end)
				.setParameter("1", begin)
				.list();
	}
	
}
