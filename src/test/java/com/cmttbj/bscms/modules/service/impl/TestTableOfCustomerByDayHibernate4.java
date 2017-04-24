package com.cmttbj.bscms.modules.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestTableOfCustomerByDayHibernate4 {
	/**
	 * @author Jiangnan
	 * @since 2017-04-10
	 */

	@Before  
	public void beforeClass() {  
	}  
	@SuppressWarnings("deprecation")
	@Test
	public void testValidLogin() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		tx.commit();
		sess.close();
	}	
}
