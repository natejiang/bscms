package com.cmttbj.bscms.modules.action;

import java.util.List;
import java.util.TreeMap;

import com.cmttbj.bscms.common.util.PageBean;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceCentreAction extends ActionSupport {
	/**
	 * @author jiangnan
	 * @date 2017-05-21
	 */
	private static final long serialVersionUID = 48L;
	
	private ServiceCentre serviceCentre;
	private ServiceCentreService serviceCentreService;
	private int id;
	private String tip;
	
	private int page;    //第几页   
    private PageBean<ServiceCentre> pageBean; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<ServiceCentre> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<ServiceCentre> pageBean) {
		this.pageBean = pageBean;
	}

	public String add() throws Exception{
		serviceCentreService.addServiceCentre(serviceCentre);
		ActionContext ctx = ActionContext.getContext();
		List<ServiceCentre> list = serviceCentreService.findAll();
		ctx.getApplication().put("serviceCentreList",list);
		setTip(":新增服务站成功");	
		return SUCCESS;	
	}
	
	public String deleteById() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		TreeMap<String, Object> Params =  (TreeMap<String, Object>) ctx.getParameters();
		//返回值为数组
		String[] ids = (String[]) Params.get("id");
		boolean isDelete = serviceCentreService.deleteById(Integer.parseInt(ids[0]));
		if(isDelete){
			List<ServiceCentre> list = serviceCentreService.findAll();
			ctx.getApplication().put("serviceCentreList",list);
			setTip(":删除服务站成功");	
		}else{
			setTip(":删除服务站失败");	
		}
		return "delete";	
	}
	
    public String list() throws Exception {
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
        this.pageBean = serviceCentreService.queryForPage(20, page);
        return "list_success";
	}
    
}
