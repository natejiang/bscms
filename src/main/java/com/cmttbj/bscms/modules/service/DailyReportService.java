package com.cmttbj.bscms.modules.service;

import com.cmttbj.bscms.modules.entity.DailyReport;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public interface DailyReportService {
	//添加日报表
	int addDailyReport(DailyReport dailyReport, ServiceCentre serviceCentre);
}
