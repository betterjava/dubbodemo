package com.lixiaodao.dubbotest.demo;

import java.lang.reflect.Method;

/**
 * @author cookie.liya
 * @date   Jun 24, 2017
 */
public class DubboInvoker<T> {
	private T proxy;
	private Class<?> clazz;
	
	public DubboInvoker(T proxy, Class<?> clazz) {
		super();
		this.proxy = proxy;
		this.clazz = clazz;
	}
	
	public Object invoke(String methodName,Class[] parameclass, Object[] args) throws Throwable {
		Method method = proxy.getClass().getMethod(methodName, parameclass);
		return method .invoke(proxy, args);
	}
	
}


