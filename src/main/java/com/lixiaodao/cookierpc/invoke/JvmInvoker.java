package com.lixiaodao.cookierpc.invoke;

import java.lang.reflect.Method;

/**
 * @author cookie.liya
 * @date   Jul 3, 2017
 */
public class JvmInvoker<T> implements Invoker<T> {
	
	private T proxy;
	
	private Class<T> interfaceClazz;
	
	@Override
	public Class<T> getInterface() {
		return interfaceClazz;
	}

	@Override
	public Object invoke(Invocation invocation) throws Throwable{
		Method method = proxy.getClass().getMethod(invocation.getMethodName(), invocation.getParamTypes());
		return method.invoke(proxy, invocation.getParams());
	}
	
	
	public void setProxy(T proxy) {
		this.proxy = proxy;
	}
	public void setInterfaceClazz(Class<T> interfaceClazz) {
		this.interfaceClazz = interfaceClazz;
	}
}


