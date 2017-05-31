package com.cmttbj.bscms.modules.service.impl;

import java.util.List;

import com.cmttbj.bscms.common.util.PageBean;
import com.cmttbj.bscms.modules.dao.UserInfoDao;
import com.cmttbj.bscms.modules.entity.UserInfo;
import com.cmttbj.bscms.modules.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	/**
	 * @author Jiangnan
	 * @date 2017-04-09
	 */
	private UserInfoDao userInfoDao;
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public List<UserInfo> validLogin(UserInfo userInfo) {
		List<UserInfo> list = userInfoDao.findByUsernameAndPassword(userInfo);
		return list;		
	}
	@Override
	public int addUserInfo(UserInfo userInfo) {
		userInfoDao.update(userInfo);
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		try
		{
			userInfoDao.delete(UserInfo.class,id);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
		finally{}
	}

	@Override
	public PageBean<UserInfo> queryForPage(int pageSize, int page) {
		//final String hql = "from ServiceCentre";        //查询语句
        long allRow = userInfoDao.findCount(UserInfo.class);    //总记录数
        long totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        //final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<UserInfo> list = userInfoDao.findByPageOrderById(UserInfo.class, currentPage, length);      //"一页"的记录
        
        //把分页信息保存到Bean中
        PageBean<UserInfo> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}

	@Override
	public List<UserInfo> findAll() {
		List<UserInfo> list = userInfoDao.findAllOrderById(UserInfo.class);
		for (int i = 0;i < list.size();i ++)
		{
			System.out.println(list.get(i).getUserId() + list.get(i).getUsername());
		}
		return list;
	}

	@Override
	public List<UserInfo> searchByUsername(UserInfo userInfo) {
		List<UserInfo> list = userInfoDao.findByUsername(userInfo);
		return list;
	}
}
