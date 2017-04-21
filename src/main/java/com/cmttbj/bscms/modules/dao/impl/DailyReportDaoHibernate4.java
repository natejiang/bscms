package com.cmttbj.bscms.modules.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.cmttbj.bscms.modules.dao.DailyReportDao;
import com.cmttbj.bscms.modules.entity.DailyReport;
import com.cmttbj.bscms.modules.entity.ServiceCentre;

public class DailyReportDaoHibernate4 implements DailyReportDao{
	/**
	 * 实现DailyReport所有Field对象的数据库存操作
	 * 注意:此DAO类没有继承BaseDaoHibernaternate4
	 * @author Jiangnan
	 * @date 2017-04-13
	 * 
	 */
	private SessionFactory sessionFactory;	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//根据日期与服务网点删除所符合条件数据
	@Override
	public void deleteByDateAndServiceCentre(Class<DailyReport> clazz, Date date, ServiceCentre serviceCentre) {
		Field[] fields = DailyReport.class.getDeclaredFields();
		for(int i = 1, len = fields.length;i < len; i ++){
			
			System.out.println(fields[i].getType().getSimpleName());
			getSessionFactory().getCurrentSession().createQuery("delete " + fields[i].getType().getSimpleName() + 
					" en where en.date = ?0 and en.serviceCentre = ?1")
					.setParameter("0", date)
					.setParameter("1", serviceCentre)
					.executeUpdate();
		}		
	}
	//实体化DailyReport相关所有类
	@Override
	public void save(DailyReport dailyReport) {
		Method[] methods = DailyReport.class.getDeclaredMethods();	
		for (int i = 0, len = methods.length; i < len; i++){
			try {				
					String methodName = methods[i].toString();
					System.out.println(methods[i].toString());
					if(methodName.indexOf("get") > 0){
					getSessionFactory().getCurrentSession().save(methods[i].invoke(dailyReport));
				}								
			} catch (HibernateException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}					
		}	
	}	
}
