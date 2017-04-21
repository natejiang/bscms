package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.entity.RenewBroadband;

public interface RenewBroadbandDao extends BaseDao<RenewBroadband>,DailyReportCommonDao<RenewBroadband>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
	//
	List<RenewBroadband> findAllOrderById(Class<RenewBroadband> entityClazz);	
	//
	List<RenewBroadband> findByPageOrderById(Class<RenewBroadband> entityClazz,int pageNo,int pageSize);

}
