package com.cmttbj.bscms.modules.action;

import java.util.List;

import com.cmttbj.bscms.modules.entity.ManagerInfo;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.UserInfo;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
import com.cmttbj.bscms.modules.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {
	/**
	 * @author Jiangnan
	 * @date 2017-04-11
	 */
	private static final long serialVersionUID = 48L;
	
	private UserInfo userInfo;
	private ManagerInfo managerInfo;
	private Integer serviceCentreId;
	private UserInfoService userInfoService;
	private ServiceCentreService serviceCentreService;
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ManagerInfo getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(ManagerInfo managerInfo) {
		this.managerInfo = managerInfo;
	}

	public Integer getServiceCentreId() {
		return serviceCentreId;
	}

	public void setServiceCentreId(Integer serviceCentreId) {
		this.serviceCentreId = serviceCentreId;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public ServiceCentreService getServiceCentreService() {
		return serviceCentreService;
	}

	public void setServiceCentreService(ServiceCentreService serviceCentreService) {
		this.serviceCentreService = serviceCentreService;
	}

	public String add(){
		List<ServiceCentre> list = serviceCentreService.findServiceCentreById(serviceCentreId);
		userInfo.setServiceCentre(list.get(0));		
		userInfoService.addUserInfo(userInfo);
		return SUCCESS;
	}
	public String addManager(){
		userInfoService.addUserInfo(managerInfo);
		return SUCCESS;
	}
	
}
