package com.cmttbj.bscms.modules.service;

import java.util.List;

import com.cmttbj.bscms.modules.entity.UserInfo;

public interface UserInfoService {
	int addUserInfo(UserInfo userInfo);
	List<UserInfo> validLogin(UserInfo userInfo);
	
	
}
