package com.cmttbj.bscms.modules.dao.impl;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.UserInfoDao;
import com.cmttbj.bscms.modules.entity.UserInfo;

public class UserInfoDaoHibernate4 extends BaseDaoHibernate4<UserInfo>
	implements UserInfoDao{

	@Override
	public List<UserInfo> findAllOrderById(Class<UserInfo> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<UserInfo> findByPageOrderById(Class<UserInfo> entityClazz, int pageNo, int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);
	}

	@Override
	public List<UserInfo> findByUsernameAndPassword(Class<UserInfo> entityClazz, String username, String password) {
		return find("select en from " + entityClazz.getSimpleName() + " en where en.username = ? and en.password = ?", username, password);
	}

}
