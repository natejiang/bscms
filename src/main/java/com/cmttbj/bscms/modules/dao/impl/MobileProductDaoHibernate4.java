package com.cmttbj.bscms.modules.dao.impl;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.MobileProductDao;
import com.cmttbj.bscms.modules.entity.MobileProduct;

public class MobileProductDaoHibernate4 extends BaseDaoHibernate4<MobileProduct> 
	implements MobileProductDao{

	@Override
	public List<MobileProduct> findAllOrderById(Class<MobileProduct> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc");
	}

	@Override
	public List<MobileProduct> findByPageOrderById(Class<MobileProduct> entityClazz, int pageNo,
			int pageSize) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en" + " order by en.id desc";
		return findByPage(hql,pageNo,pageSize);
	}

}
