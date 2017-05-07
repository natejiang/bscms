package com.cmttbj.bscms.common.config;

import java.util.HashMap;
import java.util.Map;

public class WebConstant {
	public final static String USERNAME = "username";
	
	public final static String FULLNAME = "fullname";
	
	public final static String SER_CENTRE = "serviceCentre";

	@SuppressWarnings("serial")
	public  static Map<String,String> COMPANYS = new HashMap<String, String>()
			{
				{
					COMPANYS.put("centre", "中心区");
					COMPANYS.put("south", "南区");
					COMPANYS.put("north", "北区");
					COMPANYS.put("chaoyang", "朝阳");
					COMPANYS.put("tongshun", "通顺");
					COMPANYS.put("jiaoqv", "郊区");
					COMPANYS.put("changyan", "昌延");
				}
			};
	
	
}

