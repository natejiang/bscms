package com.cmttbj.bscms.modules.dao;

import java.util.Date;
import com.cmttbj.bscms.modules.entity.DailyReport;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

/**
 * DailyReport类所有Field数据库操作
 * @author Jiangnan
 * @date 2017-04-11
 */
public interface DailyReportDao {
	
	//根据日期、服务站点删除所有记录
	void deleteByDateAndServiceCentre(Class<DailyReport> clazz, Date date, ServiceCentre serviceCentre);
	//实体化DailyReport相关所有类
	void save(DailyReport dailyReport);
	
}
