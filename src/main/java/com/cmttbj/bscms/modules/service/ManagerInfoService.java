package com.cmttbj.bscms.modules.service;

import com.cmttbj.bscms.modules.entity.ManagerInfo;

/**
 * @author jiangnan
 * @date 2017-05-02
 */
public interface ManagerInfoService {
	
	int validLogin(ManagerInfo managerInfo);
	int addManagerInfo(ManagerInfo managerInfo);

}
