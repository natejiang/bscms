package com.cmttbj.bscms.modules.action;

import com.cmttbj.bscms.common.config.WebConstant;
import com.cmttbj.bscms.modules.entity.ManagerInfo;
import com.cmttbj.bscms.modules.service.ManagerInfoService;
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
			ctx.getSession().put(WebConstant.USER, managerInfo.getUsername());
			addActionMessage("OK");
			return USR_RESULT;
		}else if(result == LOGIN_MGR)
		{
			ctx.getSession().put(WebConstant.USER, managerInfo.getUsername());
			return MGR_RESULT;
		}else
		{
			return ERROR;
		}
		
	}	
	public String logout() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put(WebConstant.USER, "");
		return LOGIN;
	}
}
