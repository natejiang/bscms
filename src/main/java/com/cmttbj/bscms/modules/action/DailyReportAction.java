package com.cmttbj.bscms.modules.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.DailyReport;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.common.util.MergeClass;
import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.entity.DoorToDoor;
import com.cmttbj.bscms.modules.entity.MobileProduct;
import com.cmttbj.bscms.modules.entity.NewBroadband;
import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.service.DailyReportService;
import com.cmttbj.bscms.modules.service.DoorToDoorService;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
import com.cmttbj.bscms.modules.service.NewBroadbandService;
import com.cmttbj.bscms.modules.service.RenewBroadbandService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DailyReportAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	/**
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
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
		serviceCentreId = (Integer)ctx.getSession().get("serviceCentreId");	
		serviceCentre = serviceCentreService.findServiceCentreById(serviceCentreId).get(0);
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
		ActionContext ctx = ActionContext.getContext();
		
		serviceCentre = (ServiceCentre) ctx.getSession().get("serviceCentre");	
		Calendar b = Calendar.getInstance();
		b.roll(5, -1);	
		//昨天
		Date begin = b.getTime();		
		Calendar c = Calendar.getInstance();
		System.out.println(c.toString());
		//当月第一天，如此写原因未知
		c.roll(5, 1-c.get(5));;	
		Date end = c.getTime();	
		System.out.println(begin.toString());
		System.out.println(end.toString());
		
		List<NewBroadband> list = newBroadbandService.searchNewBroadbandByDatesAndServiceCentre(end, begin, serviceCentre);
		ctx.put("newBroadband", list.get(0));		
		
		List<Object> listNewBroadbandTotal = newBroadbandService.sumNewBroadbandByDatesAndServiceCentre(end, begin, serviceCentre);
//		String[] prams = {"ihomeBroadbandQuantity20",
//				"ihomeBroadbandQuantity30",
//				"ihomeBroadbandQuantity50",
//				"ihomeBroadbandQuantity100",
//				"onlyBroadbandQuantity20",
//				"onlyBroadbandQuantity30",
//				"onlyBroadbandQuantity50",
//				"onlyBroadbandQuantity100"
//				};
//		MergeClass<NewBroadband> mc = new MergeClass<>();
//		NewBroadband newBroadbandTotal = (NewBroadband)mc.merger(list, prams,NewBroadband.class);	
		
		Object[] objs = (Object[]) listNewBroadbandTotal.get(0);
		System.out.println(objs.toString());
		ctx.put("newBroadbandTotal", objs);	
		
		List<RenewBroadband> list1 = renewBroadbandService.searchRenewBroadbandByDatesAndServiceCentre(end, begin, serviceCentre);
		ctx.put("renewBroadband", list1.get(0));			
		String[] prams1 = {"ihomeBroadbandQuantity20",
				"ihomeBroadbandQuantity30",
				"ihomeBroadbandQuantity50",
				"ihomeBroadbandQuantity100",
				"onlyBroadbandQuantity20",
				"onlyBroadbandQuantity30",
				"onlyBroadbandQuantity50",
				"onlyBroadbandQuantity100"
				};
		MergeClass<RenewBroadband> mc1 = new MergeClass<>();
		RenewBroadband renewBroadbandTotal = (RenewBroadband)mc1.merger(list1, prams1,RenewBroadband.class);	
		ctx.put("renewBroadbandTotal", renewBroadbandTotal);	
		
//		List<Object> list3 = doorToDoorService.sumDoorToDoorByDatesAndServiceCentre(end, begin, serviceCentre);
//		for(Object d : list3){
//			Object[] objs = (Object[])d;
//			System.out.println(objs[0].toString());
//			System.out.println(objs[1].toString());
//		}
				
		return "show";		
		
		
	}	
}
