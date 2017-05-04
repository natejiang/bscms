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
	private Integer serviceCentreId;
	private ServiceCentre serviceCentre;
	private DailyReportService dailyReportService;
	private ServiceCentreService serviceCentreService;
	private NewBroadbandService newBroadbandService;
	private RenewBroadbandService renewBroadbandService;
	private DoorToDoorService doorToDoorService;
	private MobileProductService mobileProductService;
	private CustomerService customerService;
		
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

	public Integer getServiceCentreId() {
		return serviceCentreId;
	}

	public void setServiceCentreId(Integer serviceCentreId) {
		this.serviceCentreId = serviceCentreId;
	}

	public RenewBroadbandService getRenewBroadbandService() {
		return renewBroadbandService;
	}

	public void setRenewBroadbandService(RenewBroadbandService renewBroadbandService) {
		this.renewBroadbandService = renewBroadbandService;
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
		//展示该服务中心昨天新装宽带数据
		List<NewBroadband> listNewBroadband = newBroadbandService
				.searchNewBroadbandByDatesAndServiceCentre(begin, begin, serviceCentre);
		ctx.put("newBroadband", listNewBroadband.get(0));		
		//展示该服务中心月累计新装宽带数据,注意字符串数组顺序问题
		List<String> sumNewBroadbandMonth = newBroadbandService
				.sumNewBroadbandByDatesAndServiceCentre(end, begin, serviceCentre);	
		ctx.put("newBroadbandSum", sumNewBroadbandMonth);	
		//*************************************************************************
		//展示该服务中心昨天续费宽带数据
		List<RenewBroadband> listRenewBroadband = renewBroadbandService
				.searchRenewBroadbandByDatesAndServiceCentre(begin, begin, serviceCentre);
		ctx.put("renewBroadband", listRenewBroadband.get(0));
		//展示该服务中心月累计续费宽带数据,注意字符串数组顺序问题
		List<String> sumRenewBroadbandMonth = newBroadbandService
				.sumNewBroadbandByDatesAndServiceCentre(end, begin, serviceCentre);	
		ctx.put("renewBroadbandSum", sumRenewBroadbandMonth);	
		//*************************************************************************	
		//展示该服务中心昨天客流量宽带数据
		List<Customer> listCustomer = customerService
				.searchCustomerByDatesAndServiceCentre(begin, begin, serviceCentre);
		ctx.put("customer", listCustomer.get(0));
		//展示该服务中心月累计客流量数据,注意字符串数组顺序问题
		List<String> sumCustomerMonth = customerService
				.sumCustomerByDatesAndServiceCentre(end, begin, serviceCentre);	
		System.out.println(sumCustomerMonth.get(0).toString());
		ctx.put("sumCustomerMonth", sumCustomerMonth);			
		//*************************************************************************			
		//展示该服务中心昨天上门工作量数据
		List<DoorToDoor> listDoorToDoor = doorToDoorService
				.searchDoorToDoorByDatesAndServiceCentre(begin, begin, serviceCentre);
		ctx.put("doorToDoor", listDoorToDoor.get(0));
		//展示该服务中心月累计上门工作量数据,注意字符串数组顺序问题
		List<Object> listDoorToDoorSum = doorToDoorService
				.sumDoorToDoorByDatesAndServiceCentre(end, begin, serviceCentre);	
		Object[] objs3 = (Object[])listDoorToDoorSum.get(0);	
		String[] strs3 = new String[objs3.length];
		for (int i = 0; i < objs3.length; i ++){
			strs3[i] = objs3[i].toString();
		}
		ctx.put("doorToDoorSum", strs3);	
		//*************************************************************************	
		//展示该服务中心昨天移动产品数据
		List<MobileProduct> listMobileProduct = mobileProductService
				.searchMobileProductByDatesAndServiceCentre(begin, begin, serviceCentre);
		ctx.put("mobileProduct", listMobileProduct.get(0));
		//展示该服务中心月累计移动产品数据,注意字符串数组顺序问题
		List<Object> listMobileProductSum = mobileProductService
				.sumMobileProductByDatesAndServiceCentre(end, begin, serviceCentre);	
		Object[] objs4 = (Object[])listMobileProductSum.get(0);	
		String[] strs4 = new String[objs4.length];
		for (int i = 0; i < objs4.length; i ++){
			strs4[i] = objs4[i].toString();
		}
		ctx.put("mobileProductSum", strs4);		
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
		List<String> sumNewBroadbandYestoday = newBroadbandService.sumNewBroadbandByDates(begin, begin);		
		ctx.put("sumNewBroadbandYestoday", sumNewBroadbandYestoday);		
		//展示所有服务中心月累计新装宽带数据,注意字符串数组顺序问题
		List<String> sumNewBroadbandMonth = newBroadbandService.sumNewBroadbandByDates(end, begin);	
		ctx.put("newBroadbandSum", sumNewBroadbandMonth);	
		//*************************************************************************
		//展示所有服务中心昨天续费宽带数据
		List<String> sumRenewBroadbandYesterday = renewBroadbandService.sumRenewBroadbandByDates(begin, begin);
		ctx.put("sumRenewBroadbandYesterday", sumRenewBroadbandYesterday);
		//展示该服务中心月累计续费宽带数据,注意字符串数组顺序问题
		List<String> sumRenewBroadbandMonth = renewBroadbandService.sumRenewBroadbandByDates(end, begin);	
		ctx.put("sumRenewBroadbandMonth", sumRenewBroadbandMonth);	
		//*************************************************************************	
		//展示该服务中心昨天客流量宽带数据
		List<String> sumCustomerYestoday = customerService.sumCustomerByDates(begin, begin);
		ctx.put("sumCustomerYestoday", sumCustomerYestoday);
		//展示该服务中心月累计客流量数据,注意字符串数组顺序问题
		List<String> sumCustomerMonth = customerService.sumCustomerByDates(end, begin);				
		ctx.put("sumCustomerMonth", sumCustomerMonth);			
		//*************************************************************************			
		//展示该服务中心昨天上门工作量数据
		List<String> sumDoorToDoorYestoday = doorToDoorService.sumDoorToDoorByDates(begin, begin);
		ctx.put("sumDoorToDoorYestoday", sumDoorToDoorYestoday);
		//展示该服务中心月累计上门工作量数据,注意字符串数组顺序问题
		List<String> sumDoorToDoorMonth = doorToDoorService.sumDoorToDoorByDates(end, begin);	
		ctx.put("sumDoorToDoorMonth", sumDoorToDoorMonth);	
		//*************************************************************************	
		//展示所有服务中心昨天移动产品数据
		List<String> sumMobileProductYestoday = mobileProductService.sumMobileProductByDates(begin, begin);
		ctx.put("sumMobileProductYestoday", sumMobileProductYestoday);
		//展示所有服务中心月累计移动产品数据,注意字符串数组顺序问题
		List<String> sumMobileProductMonth = mobileProductService.sumMobileProductByDates(end, begin);	
		ctx.put("sumMobileProductMonth", sumMobileProductMonth);		
		return "showAll";						
	}	
}
