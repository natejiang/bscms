package com.cmttbj.bscms.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel导出工具类,通过类反射实现，也可以考虑采用正则表达式提高效率
 * @author jiangnan
 *　@date 2017-05-21
 */
public class ExcelUtil {
	
	private HSSFWorkbook wb;

	public ExcelUtil(HSSFWorkbook wb) {
		super();
		this.wb = wb;
	}
	
	public HSSFWorkbook getWb() {
		return wb;
	}

	public void setWb(HSSFWorkbook wb) {
		this.wb = wb;
	}

	public <T> ExcelUtil addSheet(List<T> list,String[] prams,Class<T> clazz) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String sheetName = clazz.getSimpleName();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow titleRow = sheet.createRow(0);
		for (int i = 0; i < prams.length; i++) 
		{
			HSSFCell cell = titleRow.createCell(i);
			cell.setCellValue(prams[i]);
		}		
		for (int i = 0; i < list.size(); i++)
		{
			HSSFRow content = sheet.createRow(i + 1);			
			for (int j = 0; j < prams.length; j++)
			{
				String mtdName = "get" + prams[j].substring(0,1).toUpperCase() + prams[j].substring(1);
				Method method = list.get(i).getClass().getDeclaredMethod(mtdName);				
				HSSFCell cell = content.createCell(j);
				String tmp = method.invoke(list.get(i)).toString();						
				HSSFCellStyle cellStyle = wb.createCellStyle();
	            cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
	            //是否为正整数，如果为正整数则以数字格式输入EXCEL表
	            String regEx = "^-?\\d+$";
	            Pattern pattern = Pattern.compile(regEx);
	            Matcher matcher = pattern.matcher(tmp);	            
	            if(matcher.find()){
	            	cell.setCellStyle(cellStyle);
		            cell.setCellValue(Integer.valueOf(tmp));
		            System.out.println(Integer.valueOf(tmp));
	            }else{
	            	cell.setCellValue(tmp);            	
	            }            
			}						
		}		
		return this;				
	}
}
