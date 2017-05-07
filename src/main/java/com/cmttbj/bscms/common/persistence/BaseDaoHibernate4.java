package com.cmttbj.bscms.common.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;


public class BaseDaoHibernate4<T> implements BaseDao<T> {
	/**
	 * @author Jiangnan
	 * @date 2017-04-07
	 */
	private SessionFactory sessionFactory;
	//依赖注入SessionFactory所需的getter,setter方法
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//根据ID加载实体
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}
	//保存实体
	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}
	//更新实体
	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);			
	}
	//删除实体
	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);		
	}
	//根据ID删除实体
	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0")
			.setParameter("0", id)
			.executeUpdate();
	}
	//获取实体总数
	@Override
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		if (l != null && l.size() ==1)
		{
			return (Long)l.get(0);
		}
		return 0;
	}
	//根据HQL语句查询实体
	@SuppressWarnings("unchecked") 
	protected List<T> find(String hql)
	{
		return (List<T>)getSessionFactory().getCurrentSession()
				.createQuery(hql)
				.list();
	}
	//要据带占位符参数的HQL语句查询实体
	@SuppressWarnings("unchecked") 
	protected List<T> find(String hql,Object... params)
	{
		//创建查询
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0 , len = params.length ; i < len ; i ++)
		{
			query.setParameter(i, params[i]);
		}
		return (List<T>)query.list();
	}	
	/**
	 * 使用HQL语句进行分页查询操作
	 * @param hql 需要查询的HQL语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,int pageNo,int pageSize)
	{
		//创建查询
		return getSessionFactory().getCurrentSession()
				.createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
	/**
	 * 使用HQL语句进行分页查询操作
	 * @param hql 需要查询的HQL语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,int pageNo,int pageSize,Object... params)
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//包含占位符的HQL语句设置参数
		for(int i = 0 , len = params.length ; i < len ; i ++)
		{
			query.setParameter(i, params[i]);
		}
		//执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
}