package com.cmttbj.bscms.modules.service;

import java.util.List;

import com.cmttbj.bscms.common.util.PageBean;
import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.entity.UserInfo;

public interface ServiceCentreService {
	/**
	 * @author Jiangnan 
	 * @date 2017-04-10
	 * @param serviceCentre
	 * @return
	 */
	int addServiceCentre(ServiceCentre serviceCentre);
	/**
	 * 删除数据根据序号
	 * @author Jiangnan 
	 * @date 2017-05-18
	 * @param serviceCentre
	 * @return
	 */
	boolean deleteById(Integer id) throws Exception;
	List<ServiceCentre> findServiceCentreById(Integer serviceCentre_id);
	List<ServiceCentre> findAll();
	
	/**
     * 分页查询
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean<ServiceCentre> queryForPage(int pageSize, int page);
}
