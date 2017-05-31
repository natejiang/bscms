package com.cmttbj.bscms.modules.service;

import java.util.List;

import com.cmttbj.bscms.common.util.PageBean;
import com.cmttbj.bscms.modules.entity.UserInfo;

public interface UserInfoService {
	int addUserInfo(UserInfo userInfo);
	/**
	 * 删除数据根据序号
	 * @author Jiangnan 
	 * @date 2017-05-18
	 * @param serviceCentre
	 * @return
	 */
	boolean deleteById(Integer id) throws Exception;
	
	List<UserInfo> validLogin(UserInfo userInfo);
	
	public PageBean<UserInfo> queryForPage(int pageSize, int page);
	
	List<UserInfo> findAll();	    
    //检验用户名是否存在   
	public List<UserInfo> searchByUsername(UserInfo userInfo);
}
