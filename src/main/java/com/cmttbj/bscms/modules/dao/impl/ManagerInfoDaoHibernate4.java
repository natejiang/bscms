package com.cmttbj.bscms.modules.dao.impl;

import java.util.List;

import com.cmttbj.bscms.common.persistence.BaseDaoHibernate4;
import com.cmttbj.bscms.modules.dao.ManagerInfoDao;
import com.cmttbj.bscms.modules.entity.ManagerInfo;

public class ManagerInfoDaoHibernate4 extends BaseDaoHibernate4<ManagerInfo>
	implements ManagerInfoDao{

	@Override
	public List<ManagerInfo> findAllOrderById(Class<ManagerInfo> entityClazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManagerInfo> findByPageOrderById(Class<ManagerInfo> entityClazz, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManagerInfo> findByUsernameAndPassword(ManagerInfo managerInfo) {
		return find("select m from ManagerInfo m where m.username = ? and m.password = ?"
				, managerInfo.getUsername(), managerInfo.getPassword());
	}

}
