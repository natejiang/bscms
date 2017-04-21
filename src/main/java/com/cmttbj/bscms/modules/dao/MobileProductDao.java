package com.cmttbj.bscms.modules.dao;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDao;
import com.cmttbj.bscms.modules.entity.MobileProduct;

public interface MobileProductDao extends BaseDao<MobileProduct>{
	/**
	 * @author Jiangnan
	 * @date 2017-04-08
	 */
	//鑾峰彇鎵�鏈夊疄浣撴寜鏃ユ湡鍜屾椂闂存帓搴�
	List<MobileProduct> findAllOrderById(Class<MobileProduct> entityClazz);	
	//鍒嗛〉鑾峰彇瀹炰綋鎸夋棩鏈熷拰鏃堕棿鎺掑簭
	List<MobileProduct> findByPageOrderById(Class<MobileProduct> entityClazz,int pageNo,int pageSize);
}
