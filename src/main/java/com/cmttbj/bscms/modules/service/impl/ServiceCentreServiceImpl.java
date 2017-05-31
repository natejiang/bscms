package com.cmttbj.bscms.modules.service.impl;

import java.util.List;

import com.cmttbj.bscms.common.util.PageBean;
import com.cmttbj.bscms.modules.dao.ServiceCentreDao;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.ServiceCentreService;

public class ServiceCentreServiceImpl implements ServiceCentreService {
	private ServiceCentreDao serviceCentreDao;
	
	public ServiceCentreDao getServiceCentreDao() {
		return serviceCentreDao;
	}

	public void setServiceCentreDao(ServiceCentreDao serviceCentreDao) {
		this.serviceCentreDao = serviceCentreDao;
	}

	@Override
	public int addServiceCentre(ServiceCentre serviceCentre) {
		serviceCentreDao.save(serviceCentre);	
		return 0;
	}
	@Override
	public boolean deleteById(Integer id) throws Exception {
		try
		{
			serviceCentreDao.delete(ServiceCentre.class,id);
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
	public List<ServiceCentre> findServiceCentreById(Integer serviceCentre_id) {
		System.out.println(serviceCentre_id);
		List<ServiceCentre> list = serviceCentreDao.findById(ServiceCentre.class, serviceCentre_id);
		return list;
	}

	@Override
	public List<ServiceCentre> findAll() {
		List<ServiceCentre> list = serviceCentreDao.findAll();
		for (int i = 0;i < list.size();i ++)
		{
			System.out.println(list.get(i).getServiceCentreId() + list.get(i).getServiceCentreName());
		}
		return list;
	}

	@Override
	public PageBean<ServiceCentre> queryForPage(int pageSize, int page) {
		//final String hql = "from ServiceCentre";        //查询语句
        long allRow = serviceCentreDao.findCount(ServiceCentre.class);    //总记录数
        long totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        //final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<ServiceCentre> list = serviceCentreDao.findByPageOrderById(ServiceCentre.class, currentPage, length);      //"一页"的记录
        
        //把分页信息保存到Bean中
        PageBean<ServiceCentre> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}
	
}
