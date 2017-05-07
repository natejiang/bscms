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
	List<T> searchByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);	
	List<String> sumByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	List<T> searchByDates(Date end, Date begin);
	List<String> sumByDates(Date end, Date begin);
	//查询客流量根据日期和分公司
	List<T> searchByDatesAndCompany(Date end, Date begin, String company);
	List<String> sumByDatesAndCompany(Date end, Date begin, String company);

}
