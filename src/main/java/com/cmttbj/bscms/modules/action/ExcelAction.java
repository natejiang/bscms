package com.cmttbj.bscms.modules.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cmttbj.bscms.common.util.ExcelUtil;
import com.cmttbj.bscms.modules.entity.Customer;
import com.cmttbj.bscms.modules.entity.DoorToDoor;
import com.cmttbj.bscms.modules.entity.MobileProduct;
import com.cmttbj.bscms.modules.entity.NewBroadband;
import com.cmttbj.bscms.modules.entity.RenewBroadband;
import com.cmttbj.bscms.modules.service.CustomerService;
import com.cmttbj.bscms.modules.service.DoorToDoorService;
import com.cmttbj.bscms.modules.service.MobileProductService;
import com.cmttbj.bscms.modules.service.NewBroadbandService;
import com.cmttbj.bscms.modules.service.RenewBroadbandService;
import com.opensymphony.xwork2.ActionSupport;

public class ExcelAction extends ActionSupport
{
	/**
	 * @author jiangnan
	 * @date 2017-05-19
	 */
	private static final long serialVersionUID = 48L;
	private InputStream excelStream;
	private String fileName;
	
	private NewBroadbandService newBroadbandService;
	private RenewBroadbandService renewBroadbandService;
	private DoorToDoorService doorToDoorService;
	private MobileProductService mobileProductService;
	private CustomerService customerService;
	private String company;
	
	private Date begin;
	private Date end;
	
	public NewBroadbandService getNewBroadbandService() {
		return newBroadbandService;
	}

	public void setNewBroadbandService(NewBroadbandService newBroadbandService) {
		this.newBroadbandService = newBroadbandService;
	}

	public RenewBroadbandService getRenewBroadbandService() {
		return renewBroadbandService;
	}

	public void setRenewBroadbandService(RenewBroadbandService renewBroadbandService) {
		this.renewBroadbandService = renewBroadbandService;
	}

	public DoorToDoorService getDoorToDoorService() {
		return doorToDoorService;
	}

	public void setDoorToDoorService(DoorToDoorService doorToDoorService) {
		this.doorToDoorService = doorToDoorService;
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

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String exportExcel() 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		HSSFWorkbook wb = new HSSFWorkbook();
		String[] endArr = end.toString().split(" ");
		String[] beginArr = begin.toString().split(" ");
		fileName = endArr[1] +"-" + endArr[2] + "-" + endArr[5] + "~" 
		         + beginArr[1] +"-" + beginArr[2] + "-" + beginArr[5] + "-" + company + ".xls";
		System.out.println(fileName);
		ExcelUtil excelUtil = new ExcelUtil(wb);
		List<Customer> customers;
		System.out.println(company.isEmpty());
		if(company.isEmpty()){
			customers = customerService.searchByDates(end, begin);
		}else{
			customers = customerService.searchByDatesAndCompany(end, begin, company);
		}		
		String[] prams0 = new String[]{"serviceCentre","customerQuantity","date"};		
		excelUtil = excelUtil.addSheet(customers, prams0, Customer.class);
		
		List<NewBroadband> newBroadbands;
		if(company.isEmpty()){
			newBroadbands = newBroadbandService.searchByDates(end, begin);
		}else{
			newBroadbands = newBroadbandService.searchByDatesAndCompany(end, begin, company);
		}		
		String[] prams1 = new String[]{"serviceCentre"
				,"ihomeBroadbandQuantity20"
				,"ihomeBroadbandQuantity30"
				,"ihomeBroadbandQuantity50"
				,"ihomeBroadbandQuantity100"
				,"onlyBroadbandQuantity20"
				,"onlyBroadbandQuantity30"
				,"onlyBroadbandQuantity50"
				,"onlyBroadbandQuantity100"			
				,"date"};		
		excelUtil = excelUtil.addSheet(newBroadbands, prams1, NewBroadband.class);
		
		List<RenewBroadband> renewBroadbands;
		if(company.isEmpty()){
			renewBroadbands = renewBroadbandService.searchByDates(end, begin);
		}else{
			renewBroadbands = renewBroadbandService.searchByDatesAndCompany(end, begin, company);
		}
		String[] prams2 = new String[]{"serviceCentre"
				,"ihomeBroadbandQuantity20"
				,"ihomeBroadbandQuantity30"
				,"ihomeBroadbandQuantity50"
				,"ihomeBroadbandQuantity100"
				,"onlyBroadbandQuantity20"
				,"onlyBroadbandQuantity30"
				,"onlyBroadbandQuantity50"
				,"onlyBroadbandQuantity100"			
				,"date"};		
		excelUtil = excelUtil.addSheet(renewBroadbands, prams2, RenewBroadband.class);
			
		List<DoorToDoor> doorToDoors;
		if(company.isEmpty()){
			doorToDoors = doorToDoorService.searchByDates(end, begin);
		}else{
			doorToDoors = doorToDoorService.searchByDatesAndCompany(end, begin, company);
		}		
		String[] prams3 = new String[]{"serviceCentre"
				,"installedQuantity"
				,"repairedQuantity"		
				,"date"};		
		excelUtil = excelUtil.addSheet(doorToDoors, prams3, DoorToDoor.class);
				
		List<MobileProduct> mobileProducts;
		if(company.isEmpty()){
			mobileProducts = mobileProductService.searchByDates(end, begin);
		}else{
			mobileProducts = mobileProductService.searchByDatesAndCompany(end, begin, company);
		}		
		String[] prams4 = new String[]{"serviceCentre"
				,"simQuantity"
				,"terminalQuantity"
				,"televisionQuantity"		
				,"date"};		
		excelUtil = excelUtil.addSheet(mobileProducts, prams4, MobileProduct.class);
			
		wb = excelUtil.getWb();		
		ByteArrayOutputStream os = new ByteArrayOutputStream(); 
		try {
			wb.write(os);
			os.flush();
			byte[] fileContent = os.toByteArray(); 
			excelStream = new ByteArrayInputStream(fileContent);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		return SUCCESS;					
	}
}
