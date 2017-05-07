package com.cmttbj.bscms.modules.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.dao.MobileProductDao;
import com.cmttbj.bscms.modules.entity.MobileProduct;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.MobileProductService;

public class MobileProductServiceImpl implements MobileProductService{
	private MobileProductDao mobileProductDao;
	
	public MobileProductDao getMobileProductDao() {
		return mobileProductDao;
	}

	public void setMobileProductDao(MobileProductDao mobileProductDao) {
		this.mobileProductDao = mobileProductDao;
	}

	@Override
	public List<MobileProduct> searchByDatesAndServiceCentre(Date end, Date begin,
			ServiceCentre serviceCentre) {
		List<MobileProduct> list = mobileProductDao
				.findByDatesAndServiceCentre(MobileProduct.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = mobileProductDao.sumByDatesAndServiceCentre(MobileProduct.class, end, begin, serviceCentre);		
		Object[] objs = (Object[]) objsList.get(0);  
		for (int i = 0; i < objs.length; i ++){
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}			
		}	
		return list;
	}

	@Override
	public List<MobileProduct> searchByDates(Date end, Date begin) {
		List<MobileProduct> list = mobileProductDao.findByDates(MobileProduct.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumByDates(Date end, Date begin) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = mobileProductDao.sumByDates(MobileProduct.class, end, begin);		
		Object[] objs = (Object[]) objsList.get(0);
		for (int i = 0; i < objs.length; i ++){
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}			
		}	
		return list;	
	}

	@Override
	public List<MobileProduct> searchByDatesAndCompany(Date end, Date begin, String company) {
		List<MobileProduct> list = mobileProductDao.findByDatesAndCompany(MobileProduct.class, end, begin, company);
		return list;
	}

	@Override
	public List<String> sumByDatesAndCompany(Date end, Date begin, String company) {
		List<String> list = new ArrayList<>();
		List<Object> objsList = mobileProductDao.sumByDatesAndCompany(MobileProduct.class, end, begin, company);		
		Object[] objs = (Object[]) objsList.get(0);
		for (int i = 0; i < objs.length; i ++){
			if(objs[i] == null){
				list.add(i, "0");
			}else{
				list.add(i, objs[i].toString());
			}			
		}	
		return list;
	}

}
