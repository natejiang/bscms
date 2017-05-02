package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.common.persistence.DailyReportCommonDao;
import com.cmttbj.bscms.modules.entity.DoorToDoor;

public interface DoorToDoorDao extends BaseDao<DoorToDoor>, DailyReportCommonDao<DoorToDoor>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
	//获取所有实体按序号排序
	List<DoorToDoor> findAllOrderById(Class<DoorToDoor> entityClazz);	
	//分页获取实体按序号排序
	List<DoorToDoor> findByPageOrderById(Class<DoorToDoor> entityClazz,int pageNo,int pageSize);

}
