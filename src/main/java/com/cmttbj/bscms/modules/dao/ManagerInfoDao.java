package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.modules.entity.ManagerInfo;

public interface ManagerInfoDao extends BaseDao<ManagerInfo>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-09
	 */
	//获取所有实体按序号排序
	List<ManagerInfo> findAllOrderById(Class<ManagerInfo> entityClazz);	
	//分页获取实体按序号排序
	List<ManagerInfo> findByPageOrderById(Class<ManagerInfo> entityClazz,int pageNo,int pageSize);
	//获取实体根据用户名和密码
	List<ManagerInfo> findByUsernameAndPassword(ManagerInfo managerInfo);
}
