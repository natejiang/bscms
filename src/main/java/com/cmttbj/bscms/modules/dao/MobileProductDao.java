package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.entity.MobileProduct;

public interface MobileProductDao extends BaseDao<MobileProduct>,DailyReportCommonDao<MobileProduct>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-24
	 */
	//
	List<MobileProduct> findAllOrderById(Class<MobileProduct> entityClazz);	
	//
	List<MobileProduct> findByPageOrderById(Class<MobileProduct> entityClazz,int pageNo,int pageSize);
}
