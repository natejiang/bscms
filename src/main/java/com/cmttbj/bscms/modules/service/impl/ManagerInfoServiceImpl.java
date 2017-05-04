package com.cmttbj.bscms.modules.service.impl;

import com.cmttbj.bscms.modules.dao.ManagerInfoDao;
import com.cmttbj.bscms.modules.dao.UserInfoDao;
import com.cmttbj.bscms.modules.entity.ManagerInfo;
import com.cmttbj.bscms.modules.service.ManagerInfoService;
/**
 * 
 * @author jiangnan
 * @date 2017-05-02
 */

public class ManagerInfoServiceImpl implements ManagerInfoService{
	public final Integer LOGIN_MGR = 2;
	public final Integer LOGIN_USR = 1;
	public final Integer LOGIN_FAIL = 0;
	private ManagerInfoDao managerInfoDao;
	private UserInfoDao userInfoDao;
	
	public ManagerInfoDao getManagerInfoDao() {
		return managerInfoDao;
	}
	public void setManagerInfoDao(ManagerInfoDao managerInfoDao) {
		this.managerInfoDao = managerInfoDao;
	}
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}	
	/**
	 * 
	 */
	@Override
	public int validLogin(ManagerInfo managerInfo) {
		if(managerInfoDao.findByUsernameAndPassword(managerInfo).size() >= 1)
		{
			return LOGIN_MGR;
		}else if(userInfoDao.findByUsernameAndPassword(managerInfo).size() >= 1)
		{
			return LOGIN_USR;
		}else 
		{
			return LOGIN_FAIL;
		}
	}
	@Override
	public int addManagerInfo(ManagerInfo managerInfo) {
		managerInfoDao.save(managerInfo);
		return 0;
	}
}
