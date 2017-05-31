package com.cmttbj.bscms.common.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;
/**
 * DailyReport相关实体类的Servcie类通用接口,实体类必须具备date,serviceCentre属性
 * @author jiangnan
 * @date 2017-05-06
 * @param <T>
 */
public interface DailyReportCommonService<T> {
	//查询根据日期和服务站
	List<T> searchByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);	
	//查询求和根据日期和服务站
	List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	//查询根据日期
	List<T> searchByDates(Date end, Date begin);
	//查询求和根据日期
	List<String> sumByDates(Date end, Date begin);
	//查询根据日期和分公司
	List<T> searchByDatesAndCompany(Date end, Date begin, String company);
	//查询求和根据日期和分公司
	List<String> sumByDatesAndCompany(Date end, Date begin, String company);
}
