package com.cmttbj.bscms.modules.service;

import java.util.List;

import com.cmttbj.bscms.modules.entity.UserInfo;

public interface UserInfoService {
	public List<UserInfo> validLogin(String name,String pass);
	public int addUserInfo(UserInfo userInfo);
	
	
}
