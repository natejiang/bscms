package com.cmttbj.bscms.modules.action;

import java.util.List;
import java.util.TreeMap;

import com.cmttbj.bscms.common.util.PageBean;
import com.cmttbj.bscms.modules.entity.ManagerInfo;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.UserInfo;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
import com.cmttbj.bscms.modules.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
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
	private int id;
	private String tip = null;
	
	private int page;    //第几页   
    private PageBean<UserInfo> pageBean; 
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<UserInfo> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<UserInfo> pageBean) {
		this.pageBean = pageBean;
	}

	public String add(){
		List<ServiceCentre> list = serviceCentreService.findServiceCentreById(serviceCentreId);
		userInfo.setServiceCentre(list.get(0));		
		if(userInfoService.searchByUsername(userInfo).isEmpty()){
			userInfoService.addUserInfo(userInfo);
			setTip(":新增用户成功");	
		}else{
			setTip(":用户名已被占用");						
		}
		return SUCCESS;
	}
	
	public String deleteById() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		TreeMap<String, Object> Params =  (TreeMap<String, Object>) ctx.getParameters();
		//返回值为数组
		String[] ids = (String[]) Params.get("id");
		boolean isDelete = userInfoService.deleteById(Integer.parseInt(ids[0]));
		if(isDelete){
			List<UserInfo> list = userInfoService.findAll();
			ctx.getApplication().put("userInfoList",list);
			setTip(":删除成功");	
		}else{
			setTip(":删除失败");	
		}
		return "delete";	
	}
	
	public String addManager(){		
		if(userInfoService.searchByUsername(managerInfo).isEmpty()){
			userInfoService.addUserInfo(managerInfo);
			setTip(":新增管理员成功");	
		}else{
			setTip(":用户名已被占用");						
		}
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
		return "change";
	}	
	
    public String list() throws Exception {
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
        this.pageBean = userInfoService.queryForPage(20, page);
        return "list_success";
	}
}
