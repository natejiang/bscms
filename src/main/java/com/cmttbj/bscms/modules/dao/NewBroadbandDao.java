package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.entity.NewBroadband;

public interface NewBroadbandDao extends BaseDao<NewBroadband>,DailyReportCommonDao<NewBroadband>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
	//
	List<NewBroadband> findAllOrderById(Class<NewBroadband> entityClazz);	
	//
	List<NewBroadband> findByPageOrderById(Class<NewBroadband> entityClazz,int pageNo,int pageSize);

}
