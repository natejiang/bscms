package com.cmttbj.bscms.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MergeClass<T> {
	T total = null;
	/**
	 * 对象list中对象指定Integer属性求和，并返回新的对象
	 * @author Jiangnan
	 * @param list
	 * @param prams
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public T merger(List<T> list,String[] prams,Class<T> clazz){		
		try {
			total = clazz.newInstance();
		} catch (InstantiationException e2) {
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		}
		for(int i = 0;i < prams.length;i ++){
			Integer tmp = new Integer(0);			
			for(int j = 0; j < list.size(); j ++){
				try {
					String mtdName = "get" + prams[i].substring(0,1).toUpperCase() + prams[i].substring(1);
					Method method = list.get(j).getClass().getDeclaredMethod(mtdName);
					System.out.println(method.toString());
					tmp = tmp + (Integer)method.invoke(list.get(j));					
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}		
				
			try {
				
				String mtdName = "set" + prams[i].substring(0,1).toUpperCase() + prams[i].substring(1);
				Method method = total.getClass().getDeclaredMethod(mtdName,Integer.class);
				System.out.println(method.toString()+":"+tmp);
				method.invoke(total, tmp);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		}
		System.out.println(total.toString());
		return total;		
	}
}
