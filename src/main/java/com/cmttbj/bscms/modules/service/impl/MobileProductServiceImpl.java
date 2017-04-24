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
	public List<MobileProduct> searchMobileProductByDatesAndServiceCentre(Date end, Date begin,
			ServiceCentre serviceCentre) {
		List<MobileProduct> list = mobileProductDao
				.findByDatesAndServiceCentre(MobileProduct.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<Object> sumMobileProductByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre) {
		List<Object> list = mobileProductDao.sumByDatesAndServiceCentre(MobileProduct.class, end, begin, serviceCentre);
		return list;
	}

	@Override
	public List<MobileProduct> searchMobileProductByDates(Date end, Date begin) {
		List<MobileProduct> list = mobileProductDao.findByDates(MobileProduct.class, end, begin);
		return list;
	}

	@Override
	public List<String> sumMobileProductByDates(Date end, Date begin) {
		List<Object> objsList = mobileProductDao.sumByDates(MobileProduct.class, end, begin);
		Object[] objs = (Object[]) objsList.get(0);
		List<String> list = new ArrayList<>();
		for(int i = 0;i < objs.length;i ++){
			list.add(i, objs[i].toString());
		}
		return list;
	}

}
