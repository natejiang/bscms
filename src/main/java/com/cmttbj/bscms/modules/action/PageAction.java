package com.cmttbj.bscms.modules.action;

import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport
{
	/**
	 * 页面转换Action
	 * @author Jiangnan
	 * @date 2017-04-14
	 */
	private static final long serialVersionUID = 48L;

	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}	
	public String dailyReportSubmit() throws Exception
	{
		return SUCCESS;
	}	
	public String dailyReportDashboard() throws Exception
	{
		return SUCCESS;
	}	
	public String serviceCentreRegist() throws Exception
	{
		return SUCCESS;
	}	
	public String userRegist() throws Exception
	{
		return SUCCESS;
	}
	public String managerRegist() throws Exception
	{
		return SUCCESS;
	}
}
