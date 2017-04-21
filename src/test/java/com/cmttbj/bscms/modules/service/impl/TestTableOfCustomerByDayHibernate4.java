package com.cmttbj.bscms.modules.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.cmttbj.bscms.modules.dao.impl.ServiceCentreDaoHibernate4;
import com.cmttbj.bscms.modules.dao.impl.CustomerDaoHibernate4;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.Customer;


public class TestTableOfCustomerByDayHibernate4 {
	/**
	 * @author Jiangnan
	 * @since 2017-04-10
	 */

	private CustomerDaoHibernate4 tableOfCustomerByDayDao;  
	private ServiceCentreDaoHibernate4 serviceCentreDao;
	@Before  
	public void beforeClass() {  
		tableOfCustomerByDayDao = new CustomerDaoHibernate4();
		serviceCentreDao = new ServiceCentreDaoHibernate4();
	}  
	@Test
	public void testValidLogin() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		
		Date begin = new Date();
		Calendar c = Calendar.getInstance();
		c.set(2017, 4, 12);		
		Date end = c.getTime();
		
		Integer serviceCentreId = new Integer(2);
		List<ServiceCentre> list1 = serviceCentreDao.findById(ServiceCentre.class, serviceCentreId);
		System.out.println(list1.isEmpty());
		
		List<Customer> list2 = tableOfCustomerByDayDao.findByDatesAndServiceCentre(Customer.class, begin, end, list1.get(0));
			for(Customer t : list2){
				//System.out.println(t.getCustomerQuantity() + t.getDate() + t.getServiceCentre().getServiceCentreName());
			}	
		tx.commit();
		sess.close();
	}	
}
