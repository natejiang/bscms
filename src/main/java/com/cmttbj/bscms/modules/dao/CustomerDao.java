package com.cmttbj.bscms.modules.dao;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public interface CustomerDao extends BaseDao<Customer>,DailyReportCommonDao<Customer>  {
	/**
	 * @author Jiangnan
	 * @date 2017-04-09
	 */
	//获取实体按日期和序号
	List<Customer> findByDateAndServiceCentreId(Class<Customer> clazz, Date date, ServiceCentre serviceCentre);
	List<Customer> findByDatesAndServiceCentre(Class<Customer> entityClazz, Date begin ,Date end , ServiceCentre serviceCentre);
	//获取所有实体按序号排序
	List<Customer> findAllOrderById(Class<Customer> entityClazz);	
	//分页获取实体按序号排序
	List<Customer> findByPageOrderById(Class<Customer> entityClazz,int pageNo,int pageSize);
	
	
}
