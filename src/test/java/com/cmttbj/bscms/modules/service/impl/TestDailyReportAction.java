package com.cmttbj.bscms.modules.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDailyReportAction {

	@Test
	public void test() {
		Calendar b = Calendar.getInstance();
		b.roll(5, -1);
		
		Date begin = b.getTime();
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.toString());
		//测试数据
		c.roll(5, 1-c.get(5));;	
		Date end = c.getTime();
		
		System.out.println(begin.toString());
		System.out.println(end.toString());
	}

}
