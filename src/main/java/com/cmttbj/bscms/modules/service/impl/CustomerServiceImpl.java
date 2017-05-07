package com.cmttbj.bscms.modules.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.dao.CustomerDao;
import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.CustomerService;
/**
 * 
 * @author jiangnan
 * @date 2017-04-24
 */

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> searchByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Customer> list = customerDao
				.findByDatesAndServiceCentre(Customer.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> objsList = customerDao.sumByDatesAndServiceCentre(Customer.class, end, begin, serviceCentre);
		Object obj = (Object) objsList.get(0);
		List<String> list = new ArrayList<>();
		list.add(obj.toString());			
		return list;
	}

	@Override
	public List<Customer> searchByDates(Date end, Date begin) {
		List<Customer> list = customerDao.findByDates(Customer.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumByDates(Date end, Date begin) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = customerDao.sumByDates(Customer.class, end, begin);
		Object objs = (Object) objsList.get(0);
		if(objs == null){
			list.add("0");
		}else{
			list.add(objs.toString());
		}						
		return list;								
	}
	
	@Override
	public List<Customer> searchByDatesAndCompany(Date end, Date begin, String company) {
		List<Customer> list = customerDao.findByDatesAndCompany(Customer.class, end, begin, company);
		return list;
	}

	@Override
	public List<String> sumByDatesAndCompany(Date end, Date begin, String company) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = customerDao.sumByDatesAndCompany(Customer.class, end, begin, company);
		Object objs = (Object) objsList.get(0);
		if(objs == null){
			list.add("0");
		}else{
			list.add(objs.toString());
		}						
		return list;
	}
}
