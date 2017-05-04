package com.cmttbj.bscms.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cmttbj.bscms.modules.entity.ServiceCentre;
import com.cmttbj.bscms.modules.service.ServiceCentreService;
/**
 * 初始化服务中心列表
 * @author jiangnan
 * @date 2017-05-04
 */
public class ServiceCentreInitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		ServiceCentreService serviceCentreService = (ServiceCentreService) ctx.getBean("serviceCentreService");
		List<ServiceCentre> list = serviceCentreService.findAll();
		context.setAttribute("serviceCentreList",list);
	}
}
