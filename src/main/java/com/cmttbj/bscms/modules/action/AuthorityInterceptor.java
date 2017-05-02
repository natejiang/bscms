package com.cmttbj.bscms.modules.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 48L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String username = (String)session.get("username");
		if(username != null)
		{
			return invocation.invoke();
		}else if(username != null)
		{
			
		}
		return Action.LOGIN;
	}

}
