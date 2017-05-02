package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public interface ServiceCentreDao extends BaseDao<ServiceCentre>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-10
	 */
	//获取所有实体按序号排序
	List<ServiceCentre> findAllOrderById(Class<ServiceCentre> entityClazz);	
	//分页获取实体按序号排序
	List<ServiceCentre> findByPageOrderById(Class<ServiceCentre> entityClazz,int pageNo,int pageSize);
	//获取实体按序号
	List<ServiceCentre> findById(Class<ServiceCentre> entityClazz, Integer serviceCentre_id);
}
