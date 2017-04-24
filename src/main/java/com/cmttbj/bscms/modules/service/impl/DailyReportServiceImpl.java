package com.cmttbj.bscms.modules.service.impl;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.dao.DailyReportDao;
import com.cmttbj.bscms.modules.dao.CustomerDao;
import com.cmttbj.bscms.modules.dao.DoorToDoorDao;
import com.cmttbj.bscms.modules.dao.MobileProductDao;
import com.cmttbj.bscms.modules.dao.NewBroadbandDao;
import com.cmttbj.bscms.modules.dao.RenewBroadbandDao;
import com.cmttbj.bscms.modules.entity.DailyReport;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.service.DailyReportService;

public class DailyReportServiceImpl implements DailyReportService{
	/**
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
	private CustomerDao customerDao; 
	private DoorToDoorDao doorToDoorDao; 
	private MobileProductDao mobileProductDao; 
	private NewBroadbandDao newBroadbandDao; 
	private RenewBroadbandDao renewBroadbandDao; 
	private DailyReportDao dailyReportDao;
	
	

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public DoorToDoorDao getDoorToDoorDao() {
		return doorToDoorDao;
	}

	public void setDoorToDoorDao(DoorToDoorDao doorToDoorDao) {
		this.doorToDoorDao = doorToDoorDao;
	}

	public MobileProductDao getMobileProductDao() {
		return mobileProductDao;
	}

	public void setMobileProductDao(MobileProductDao mobileProductDao) {
		this.mobileProductDao = mobileProductDao;
	}

	public NewBroadbandDao getNewBroadbandDao() {
		return newBroadbandDao;
	}

	public void setNewBroadbandDao(NewBroadbandDao newBroadbandDao) {
		this.newBroadbandDao = newBroadbandDao;
	}

	public RenewBroadbandDao getRenewBroadbandDao() {
		return renewBroadbandDao;
	}

	public void setRenewBroadbandDao(RenewBroadbandDao renewBroadbandDao) {
		this.renewBroadbandDao = renewBroadbandDao;
	}

	public DailyReportDao getDailyReportDao() {
		return dailyReportDao;
	}

	public void setDailyReportDao(DailyReportDao dailyReportDao) {
		this.dailyReportDao = dailyReportDao;
	}

	@Override
	public int addDailyReport(DailyReport dailyReport, ServiceCentre serviceCentre) {
		
		Date today = new Date();		
		List<Customer> list = customerDao.findByDateAndServiceCentreId(Customer.class, today, serviceCentre);
		//日报表每日只能存在一条记录
		if(list.isEmpty()){
			dailyReportDao.save(dailyReport);
		}else{
			dailyReportDao.deleteByDateAndServiceCentre(DailyReport.class, today, serviceCentre);
			dailyReportDao.save(dailyReport);
		}
		return 1;		
	}
}
