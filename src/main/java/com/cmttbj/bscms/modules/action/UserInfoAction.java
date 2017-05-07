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
	private UserInfoService userInfoService;
	private ServiceCentreService serviceCentreService;
	private Integer serviceCentreId;
	private String newPassword;
	private String tip = null;
	
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
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
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
	
	public String changePassword(){
		List<UserInfo> list = userInfoService.validLogin(userInfo);
		if(list.size() > 0){
			userInfo = list.get(0);
			userInfo.setPassword(newPassword);
			userInfoService.addUserInfo(userInfo);
			setTip(":密码修改成功");	
			System.out.println(tip);
			
		}else{
			setTip(":原密码错误");
			System.out.println(tip);
		}		
		return INPUT;
	}	
}
