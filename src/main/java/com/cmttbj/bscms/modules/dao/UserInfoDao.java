package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.modules.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-09
	 */
	//获取所有实体按序号排序
	List<UserInfo> findAllOrderById(Class<UserInfo> entityClazz);	
	//分页获取实体按序号排序
	List<UserInfo> findByPageOrderById(Class<UserInfo> entityClazz,int pageNo,int pageSize);
	//获取实体根据用户名和密码
	List<UserInfo> findByUsernameAndPassword(UserInfo userInfo);
}
