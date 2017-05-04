package com.cmttbj.bscms.modules.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cmttbj.bscms.modules.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class ExcelAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 48L;
	private InputStream excelStream;
	private String fileName;
	private CustomerService customerService;
	
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

	public String exportExcel(){
		String[] customerTitleArray = new String[]{"ServiceCentre","CustomerQuantity"};
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("test.xls");
		HSSFRow titleRow = sheet.createRow(0);
		for (int i = 0; i < customerTitleArray.length; i++) 
		{
			HSSFCell cell = titleRow.createCell(i);
			cell.setCellValue(customerTitleArray[i]);
		}
			
		ByteArrayOutputStream os = new ByteArrayOutputStream(); 
		try {
			wb.write(os);
			os.flush();
			byte[] fileContent = os.toByteArray(); 
			excelStream = new ByteArrayInputStream(fileContent);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return SUCCESS;	
		
		
		
	}
}
