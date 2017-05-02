package com.cmttbj.bscms.modules.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
/**
 * Customer服务类
 * @author Jiangnan
 * @date 2017-04-24
 */
public interface CustomerService {	
	List<Customer> searchCustomerByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);	
	List<String> sumCustomerByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	List<Customer> searchCustomerByDates(Date end, Date begin);
	List<String> sumCustomerByDates(Date end, Date begin);
}
