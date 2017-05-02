package com.cmttbj.bscms.modules.service;

import java.util.Date;
import java.util.List;

import com.cmttbj.bscms.modules.entity.MobileProduct;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
/**
 * 移动产品服务类
 * @author jiangnan
 * @date 2017-04-24
 */
public interface MobileProductService {
	List<MobileProduct> searchMobileProductByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);	
	List<Object> sumMobileProductByDatesAndServiceCentre(Date end, Date begin, ServiceCentre serviceCentre);
	List<MobileProduct> searchMobileProductByDates(Date end, Date begin);
	List<String> sumMobileProductByDates(Date end, Date begin);
}
