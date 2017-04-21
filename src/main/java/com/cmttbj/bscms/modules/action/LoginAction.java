package com.cmttbj.bscms.modules.action;

import java.util.List;

import com.cmttbj.bscms.modules.entity.UserInfo;
import com.cmttbj.bscms.modules.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * @author Jiangnan
	 * @date 2017-04-09
	 */
	private static final long serialVersionUID = 48L;
	private UserInfo userInfo;
	private UserInfoService userInfoService;
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String login() throws Exception{
		List<UserInfo> list = userInfoService.validLogin(userInfo.getUsername(),userInfo.getPassword());
		if (list.isEmpty()){
			return ERROR;
		}else{
			ActionContext ctx = ActionContext.getContext();	
			ctx.getSession().put("username", userInfo.getUsername());
			ctx.getSession().put("fullname", list.get(0).getFullname());
			ctx.getSession().put("serviceCentre", list.get(0).getServiceCentre());
			ctx.getSession().put("serviceCentreId", list.get(0).getServiceCentre().getServiceCentreId());
			ctx.getSession().put("serviceCentreName",list.get(0).getServiceCentre().getServiceCentreName());
			return SUCCESS;
		}		
	}
	
	public String logout() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("name", "");
		return "error";
	}
}
