package com.cmttbj.bscms.modules.service.impl;

import java.util.List;

import com.cmttbj.bscms.modules.dao.UserInfoDao;
import com.cmttbj.bscms.modules.entity.UserInfo;
import com.cmttbj.bscms.modules.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	/**
	 * @author Jiangnan
	 * @date 2017-04-09
	 */
	private UserInfoDao userInfoDao;
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public List<UserInfo> validLogin(UserInfo userInfo) {
		List<UserInfo> list = userInfoDao.findByUsernameAndPassword(userInfo);
		return list;		
	}
	@Override
	public int addUserInfo(UserInfo userInfo) {
		userInfoDao.save(userInfo);
		return 0;
	}
}
