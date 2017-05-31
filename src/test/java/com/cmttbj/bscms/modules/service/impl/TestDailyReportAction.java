package com.cmttbj.bscms.modules.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class TestDailyReportAction {

	@Test
	public void test(){
		Calendar b = Calendar.getInstance();
		b.roll(5, -1);		
		Date begin = b.getTime();
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.toString());
		System.out.println(c.get(2));
		//测试数据
		if(c.get(5) == 1){
			c.roll(2,-1);
		}else{
			c.roll(5, 1-c.get(5));;				
		}
		Date end = c.getTime();
		System.out.println(begin.toString());
		System.out.println(end.toString());
		
		String s = "4563234";
		
		String regEx = "\\d+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
		System.out.println(matcher.find());
		
		String dateStr = "2017.05.01";
		DateFormat[] dfs={
		        new SimpleDateFormat("yyyy-MM-dd"),
		        new SimpleDateFormat("MM/dd/yy"),
		        new SimpleDateFormat("yyyy.MM.dd"),
		        new SimpleDateFormat("yy.MM.dd"),
		        new SimpleDateFormat("yyyy/MM/dd"),
		        new SimpleDateFormat("MM/dd/yyyy")
		    };
		for (int i = 0; i < dfs.length;i ++)
		{
			System.out.println("this is " + i);
			 try {
	              System.out.println(dfs[i].parse(dateStr));
	            } catch (Exception e) {
	                continue;
	            }
		}
	
		
	}

}
