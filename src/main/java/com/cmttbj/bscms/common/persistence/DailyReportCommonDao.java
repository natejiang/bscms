package com.cmttbj.bscms.common.persistence;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.ServiceCentre;

/**
 * DailyReport相关Entity类的Dao类通用接口
 * @author Jiangnan
 * @date 2017-04-19
 */
public interface DailyReportCommonDao<T> {

	//获取实体按日期和服务中心
	List<T> findByDatesAndServiceCentre(Class<T> entityClazz, Date end ,Date begin , ServiceCentre serviceCentre);
	List<Object> sumByDatesAndServiceCentre(Class<T> entityClazz, Date end, Date begin,
			ServiceCentre serviceCentre);
	//获取实体按日期和公司
	List<T> findByDatesAndCompany(Class<T> entityClazz, Date end ,Date begin, String company);
	//获取实体按日期
	List<T> findByDates(Class<T> entityClazz, Date end ,Date begin);
	
}
