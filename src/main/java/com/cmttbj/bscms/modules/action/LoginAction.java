package com.cmttbj.bscms.modules.action;

import java.util.List;

import com.cmttbj.bscms.common.config.WebConstant;
import com.cmttbj.bscms.modules.entity.ManagerInfo;
import com.cmttbj.bscms.modules.entity.UserInfo;
import com.cmttbj.bscms.modules.service.ManagerInfoService;
import com.cmttbj.bscms.modules.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * @author Jiangnan
	 * @date 2017-05-02
	 */
	private final String USR_RESULT = "usr";
	private final String MGR_RESULT = "mgr";
	public final Integer LOGIN_MGR = 2;
	public final Integer LOGIN_USR = 1;
	public final Integer LOGIN_FAIL = 0;
	
	private static final long serialVersionUID = 48L;
	
	private ManagerInfo managerInfo;
	private ManagerInfoService managerInfoService;
	private UserInfoService userInfoService;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public ManagerInfo getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(ManagerInfo managerInfo) {
		this.managerInfo = managerInfo;
	}

	public ManagerInfoService getManagerInfoService() {
		return managerInfoService;
	}

	public void setManagerInfoService(ManagerInfoService managerInfoService) {
		this.managerInfoService = managerInfoService;
	}

	public String login() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		int result = managerInfoService.validLogin(managerInfo);
		System.out.println(result);
		if(result == LOGIN_USR)
		{
			List<UserInfo> list = userInfoService.validLogin(managerInfo);
			UserInfo userInfo = list.get(0);
			ctx.getSession().put(WebConstant.USERNAME, userInfo.getUsername());
			ctx.getSession().put(WebConstant.SER_CENTRE, userInfo.getServiceCentre());
			ctx.getSession().put(WebConstant.FULLNAME, userInfo.getFullname());
			return USR_RESULT;
		}else if(result == LOGIN_MGR)
		{
			ctx.getSession().put(WebConstant.USERNAME, managerInfo.getUsername());			
			return MGR_RESULT;
		}else
		{
			return ERROR;
		}
		
	}	
	public String logout() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put(WebConstant.USERNAME, "");
		return ERROR;
	}
}
