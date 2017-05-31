package com.cmttbj.bscms.modules.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.entity.DailyReport;
import com.cmttbj.bscms.modules.entity.DoorToDoor;
import com.cmttbj.bscms.modules.entity.MobileProduct;
import com.cmttbj.bscms.modules.entity.NewBroadband;
import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.CustomerService;
import com.cmttbj.bscms.modules.service.DailyReportService;
import com.cmttbj.bscms.modules.service.DoorToDoorService;
import com.cmttbj.bscms.modules.service.MobileProductService;
import com.cmttbj.bscms.modules.service.NewBroadbandService;
import com.cmttbj.bscms.modules.service.RenewBroadbandService;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author Jiangnan
 * @date 2017-04-08
 */
public class DailyReportAction extends ActionSupport {

	private static final long serialVersionUID = 48L;

	private Customer customer;
	private DoorToDoor doorToDoor;
	private MobileProduct mobileProduct;
	private NewBroadband newBroadband;
	private RenewBroadband renewBroadband;
	private ServiceCentre serviceCentre;
	private DailyReportService dailyReportService;
	private ServiceCentreService serviceCentreService;
	private NewBroadbandService newBroadbandService;
	private RenewBroadbandService renewBroadbandService;
	private DoorToDoorService doorToDoorService;
	private MobileProductService mobileProductService;
	private CustomerService customerService;
	private String company;
	private String tip;
		
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public MobileProductService getMobileProductService() {
		return mobileProductService;
	}

	public void setMobileProductService(MobileProductService mobileProductService) {
		this.mobileProductService = mobileProductService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public DoorToDoorService getDoorToDoorService() {
		return doorToDoorService;
	}

	public void setDoorToDoorService(DoorToDoorService doorToDoorService) {
		this.doorToDoorService = doorToDoorService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DoorToDoor getDoorToDoor() {
		return doorToDoor;
	}

	public void setDoorToDoor(DoorToDoor doorToDoor) {
		this.doorToDoor = doorToDoor;
	}

	public MobileProduct getMobileProduct() {
		return mobileProduct;
	}

	public void setMobileProduct(MobileProduct mobileProduct) {
		this.mobileProduct = mobileProduct;
	}

	public NewBroadband getNewBroadband() {
		return newBroadband;
	}

	public void setNewBroadband(NewBroadband newBroadband) {
		this.newBroadband = newBroadband;
	}

	public RenewBroadband getRenewBroadband() {
		return renewBroadband;
	}

	public void setRenewBroadband(RenewBroadband renewBroadband) {
		this.renewBroadband = renewBroadband;
	}

	public NewBroadbandService getNewBroadbandService() {
		return newBroadbandService;
	}

	public void setNewBroadbandService(NewBroadbandService newBroadbandService) {
		this.newBroadbandService = newBroadbandService;
	}

	public DailyReportService getDailyReportService() {
		return dailyReportService;
	}

	public void setDailyReportService(DailyReportService dailyReportService) {
		this.dailyReportService = dailyReportService;
	}

	public ServiceCentreService getServiceCentreService() {
		return serviceCentreService;
	}

	public void setServiceCentreService(ServiceCentreService serviceCentreService) {
		this.serviceCentreService = serviceCentreService;
	}
	
	public ServiceCentre getServiceCentre() {
		return serviceCentre;
	}

	public void setServiceCentre(ServiceCentre serviceCentre) {
		this.serviceCentre = serviceCentre;
	}

	public RenewBroadbandService getRenewBroadbandService() {
		return renewBroadbandService;
	}

	public void setRenewBroadbandService(RenewBroadbandService renewBroadbandService) {
		this.renewBroadbandService = renewBroadbandService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String add() throws Exception
	{
		DailyReport dailyReport = new DailyReport();
		ActionContext ctx = ActionContext.getContext();	
		serviceCentre = (ServiceCentre) ctx.getSession().get("serviceCentre");	
		customer.setServiceCentre(serviceCentre);
		dailyReport.setCustomer(customer);		
		doorToDoor.setServiceCentre(serviceCentre);
		dailyReport.setDoorToDoor(doorToDoor);		
		mobileProduct.setServiceCentre(serviceCentre);
		dailyReport.setMobileProduct(mobileProduct);		
		newBroadband.setServiceCentre(serviceCentre);
		dailyReport.setNewBroadband(newBroadband);		
		renewBroadband.setServiceCentre(serviceCentre);
		dailyReport.setRenewBroadband(renewBroadband);			
		int result = dailyReportService.addDailyReport(dailyReport, serviceCentre);		
		if(result > 0)
		{
			setTip(":上传数据成功！");
			return "add_success";
		}else
		{
			return ERROR;		
		}				
	}			
	public String show(){
		/**
		 * ServiceCentre权限仪表盘
		 * @return
		 */
		ActionContext ctx = ActionContext.getContext();
		serviceCentre = (ServiceCentre) ctx.getSession().get("serviceCentre");	
		//代表昨天
		Calendar b = Calendar.getInstance();
		b.roll(5, -1);	
		Date begin = b.getTime();	
		//代表当月第一天
		Calendar c = Calendar.getInstance();	
		//如果是月初第一天，则向前滚动一个月
		if(c.get(5) == 1){
			c.roll(2,-1);
		}else{
			c.roll(5, 1-c.get(5));;				
		}			
		Date end = c.getTime();	
		System.out.println(begin.toString());
		System.out.println(end.toString());
		//*************************************************************************	
		//展示该服务中心昨天新装宽带数据
		List<NewBroadband> listNewBroadband = newBroadbandService
				.searchByDatesAndServiceCentre(begin, begin, serviceCentre);
		if(listNewBroadband.isEmpty()){
			newBroadband = new NewBroadband();
			ctx.put("newBroadband", newBroadband);
		}else{
			ctx.put("newBroadband", listNewBroadband.get(0));
		}				
		//展示该服务中心月累计新装宽带数据,注意字符串数组顺序问题
		List<String> sumNewBroadbandMonth = newBroadbandService
				.sumByDatesAndServiceCentre(end, begin, serviceCentre);	
		ctx.put("sumNewBroadbandMonth", sumNewBroadbandMonth);	
		//*************************************************************************
		//展示该服务中心昨天续费宽带数据
		List<RenewBroadband> listRenewBroadband = renewBroadbandService
				.searchByDatesAndServiceCentre(begin, begin, serviceCentre);
		if(listRenewBroadband.isEmpty()){
			renewBroadband = new RenewBroadband();
			ctx.put("renewBroadband", renewBroadband);
		}else{
			ctx.put("renewBroadband", listRenewBroadband.get(0));
		}		
		//展示该服务中心月累计续费宽带数据,注意字符串数组顺序问题
		List<String> sumRenewBroadbandMonth = newBroadbandService
				.sumByDatesAndServiceCentre(end, begin, serviceCentre);	
		ctx.put("sumRenewBroadbandMonth", sumRenewBroadbandMonth);	
		//*************************************************************************	
		//展示该服务中心昨天客流量宽带数据
		List<Customer> listCustomer = customerService
				.searchByDatesAndServiceCentre(begin, begin, serviceCentre);
		if(listCustomer.isEmpty()){
			customer = new Customer();
			ctx.put("customer", customer);
		}else{
			ctx.put("customer", listCustomer.get(0));
		}		
		//展示该服务中心月累计客流量数据,注意字符串数组顺序问题
		List<String> sumCustomerMonth = customerService
				.sumByDatesAndServiceCentre(end, begin, serviceCentre);	
		System.out.println(sumCustomerMonth.get(0).toString());
		ctx.put("sumCustomerMonth", sumCustomerMonth);			
		//*************************************************************************			
		//展示该服务中心昨天上门工作量数据
		List<DoorToDoor> listDoorToDoor = doorToDoorService
				.searchByDatesAndServiceCentre(begin, begin, serviceCentre);
		if(listDoorToDoor.isEmpty()){
			doorToDoor = new DoorToDoor();
			ctx.put("doorToDoor", doorToDoor);
		}else{
			ctx.put("doorToDoor", listDoorToDoor.get(0));
		}		
		//展示该服务中心月累计上门工作量数据,注意字符串数组顺序问题
		List<String> sumDoorToDoorMonth = doorToDoorService.sumByDatesAndServiceCentre(end, begin,serviceCentre);				
		ctx.put("sumDoorToDoorMonth", sumDoorToDoorMonth);	
		//*************************************************************************	
		//展示该服务中心昨天移动产品数据
		List<MobileProduct> listMobileProduct = mobileProductService
				.searchByDatesAndServiceCentre(begin, begin, serviceCentre);
		if(listMobileProduct.isEmpty()){
			mobileProduct = new MobileProduct();
			ctx.put("mobileProduct",mobileProduct);
		}else{
			ctx.put("mobileProduct", listMobileProduct.get(0));
		}		
		//展示该服务中心月累计移动产品数据,注意字符串数组顺序问题
		List<String> sumMobileProductMonth = mobileProductService.sumByDatesAndServiceCentre(end, begin, serviceCentre);
		ctx.put("sumMobileProduct", sumMobileProductMonth);
		return "show";						
	}	
	
	public String showAll(){
		/**
		 * 机关权限仪表盘
		 * @return
		 */
		ActionContext ctx = ActionContext.getContext();
		Calendar b = Calendar.getInstance();
		b.roll(5, -1);	
		//代表昨天
		Date begin = b.getTime();		
		Calendar c = Calendar.getInstance();	
		c.roll(5, 1-c.get(5));;	
		//代表当月第一天
		Date end = c.getTime();	
		System.out.println(begin.toString());
		System.out.println(end.toString());
		//*************************************************************************	
		//展示所有服务中心昨天新装宽带数据
		List<String> sumNewBroadbandYesterday = newBroadbandService.sumByDates(begin, begin);		
		ctx.put("sumNewBroadbandYesterday", sumNewBroadbandYesterday);		
		//展示所有服务中心月累计新装宽带数据,注意字符串数组顺序问题
		List<String> sumNewBroadbandMonth = newBroadbandService.sumByDates(end, begin);	
		ctx.put("sumNewBroadbandMonth", sumNewBroadbandMonth);	
		//*************************************************************************
		//展示所有服务中心昨天续费宽带数据
		List<String> sumRenewBroadbandYesterday = renewBroadbandService.sumByDates(begin, begin);
		ctx.put("sumRenewBroadbandYesterday", sumRenewBroadbandYesterday);
		//展示该服务中心月累计续费宽带数据,注意字符串数组顺序问题
		List<String> sumRenewBroadbandMonth = renewBroadbandService.sumByDates(end, begin);	
		ctx.put("sumRenewBroadbandMonth", sumRenewBroadbandMonth);	
		//*************************************************************************	
		//展示该服务中心昨天客流量宽带数据
		List<String> sumCustomerYesterday = customerService.sumByDates(begin, begin);
		ctx.put("sumCustomerYesterday", sumCustomerYesterday);
		//展示该服务中心月累计客流量数据,注意字符串数组顺序问题
		List<String> sumCustomerMonth = customerService.sumByDates(end, begin);				
		ctx.put("sumCustomerMonth", sumCustomerMonth);			
		//*************************************************************************			
		//展示该服务中心昨天上门工作量数据
		List<String> sumDoorToDoorYesterday = doorToDoorService.sumByDates(begin, begin);
		ctx.put("sumDoorToDoorYesterday", sumDoorToDoorYesterday);
		//展示该服务中心月累计上门工作量数据,注意字符串数组顺序问题
		List<String> sumDoorToDoorMonth = doorToDoorService.sumByDates(end, begin);	
		ctx.put("sumDoorToDoorMonth", sumDoorToDoorMonth);	
		//*************************************************************************	
		//展示所有服务中心昨天移动产品数据
		List<String> sumMobileProductYesterday = mobileProductService.sumByDates(begin, begin);
		ctx.put("sumMobileProductYesterday", sumMobileProductYesterday);
		//展示所有服务中心月累计移动产品数据,注意字符串数组顺序问题
		List<String> sumMobileProductMonth = mobileProductService.sumByDates(end, begin);	
		ctx.put("sumMobileProductMonth", sumMobileProductMonth);
		return "showAll";						
	}	
	
	public String showCompany(){
		/**
		 * 机关权限仪表盘,查询各分公司数据
		 * @return
		 */
		ActionContext ctx = ActionContext.getContext();
		Calendar b = Calendar.getInstance();
		b.roll(5, -1);	
		//代表昨天
		Date begin = b.getTime();		
		Calendar c = Calendar.getInstance();	
		c.roll(5, 1-c.get(5));;	
		//代表当月第一天
		Date end = c.getTime();	
		System.out.println(begin.toString());
		System.out.println(end.toString());
		//*************************************************************************	
		//展示所有服务中心昨天新装宽带数据
		List<String> sumNewBroadbandYesterday = newBroadbandService.sumByDatesAndCompany(begin, begin, company);		
		ctx.put("sumNewBroadbandYesterday", sumNewBroadbandYesterday);		
		//展示所有服务中心月累计新装宽带数据,注意字符串数组顺序问题
		List<String> sumNewBroadbandMonth = newBroadbandService.sumByDatesAndCompany(end, begin, company);	
		ctx.put("sumNewBroadbandMonth", sumNewBroadbandMonth);	
		//*************************************************************************
		//展示所有服务中心昨天续费宽带数据
		List<String> sumRenewBroadbandYesterday = renewBroadbandService.sumByDatesAndCompany(begin, begin, company);
		ctx.put("sumRenewBroadbandYesterday", sumRenewBroadbandYesterday);
		//展示该服务中心月累计续费宽带数据,注意字符串数组顺序问题
		List<String> sumRenewBroadbandMonth = renewBroadbandService.sumByDatesAndCompany(end, begin, company);	
		ctx.put("sumRenewBroadbandMonth", sumRenewBroadbandMonth);	
		//*************************************************************************	
		//展示该服务中心昨天客流量宽带数据
		List<String> sumCustomerYesterday = customerService.sumByDatesAndCompany(begin, begin, company);
		ctx.put("sumCustomerYesterday", sumCustomerYesterday);
		//展示该服务中心月累计客流量数据,注意字符串数组顺序问题
		List<String> sumCustomerMonth = customerService.sumByDatesAndCompany(end, begin, company);				
		ctx.put("sumCustomerMonth", sumCustomerMonth);			
		//*************************************************************************			
		//展示该服务中心昨天上门工作量数据
		List<String> sumDoorToDoorYesterday = doorToDoorService.sumByDatesAndCompany(begin, begin, company);
		ctx.put("sumDoorToDoorYesterday", sumDoorToDoorYesterday);
		//展示该服务中心月累计上门工作量数据,注意字符串数组顺序问题
		List<String> sumDoorToDoorMonth = doorToDoorService.sumByDatesAndCompany(end, begin, company);	
		ctx.put("sumDoorToDoorMonth", sumDoorToDoorMonth);	
		//*************************************************************************	
		//展示所有服务中心昨天移动产品数据
		List<String> sumMobileProductYesterday = mobileProductService.sumByDatesAndCompany(begin, begin, company);
		ctx.put("sumMobileProductYesterday", sumMobileProductYesterday);
		//展示所有服务中心月累计移动产品数据,注意字符串数组顺序问题
		List<String> sumMobileProductMonth = mobileProductService.sumByDatesAndCompany(end, begin, company);	
		ctx.put("sumMobileProductMonth", sumMobileProductMonth);		
		return "showAll";						
	}	
}
