package com.cmttbj.bscms.modules.action;

import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceCentreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 48L;
	
	private ServiceCentre serviceCentre;
	private ServiceCentreService serviceCentreService;
	
	
	public ServiceCentre getServiceCentre() {
		return serviceCentre;
	}


	public void setServiceCentre(ServiceCentre serviceCentre) {
		this.serviceCentre = serviceCentre;
	}


	public ServiceCentreService getServiceCentreService() {
		return serviceCentreService;
	}


	public void setServiceCentreService(ServiceCentreService serviceCentreService) {
		this.serviceCentreService = serviceCentreService;
	}


	public String add() throws Exception{
		serviceCentreService.addServiceCentre(serviceCentre);
		ActionContext ctx = ActionContext.getContext();
		List<ServiceCentre> list = serviceCentreService.findAll();
		ctx.getApplication().put("serviceCentreList",list);
		return SUCCESS;	
	}
}
