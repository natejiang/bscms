package com.cmttbj.bscms.common.persistence;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;

/**
 * DailyReport相关实体类的Dao类通用接口,实体类必须具备date,serviceCentre属性
 * @author Jiangnan
 * @date 2017-04-19
 */
public interface DailyReportCommonDao<T> {

	//获取实体根据日期和服务中心	
	List<T> findByDatesAndServiceCentre(Class<T> entityClazz, Date end ,Date begin , ServiceCentre serviceCentre);
	//求和实体属性根据日期和服务中心
	List<Object> sumByDatesAndServiceCentre(Class<T> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre);
	//获取实体按日期和公司
	List<T> findByDatesAndCompany(Class<T> entityClazz, Date end ,Date begin, String company);
	//获取实体按日期
	List<T> findByDates(Class<T> entityClazz, Date end ,Date begin);
	//求和实体属性根据日期
	List<Object> sumByDates(Class<T> entityClazz, Date end, Date begin);
	
}
