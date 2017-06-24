package com.lixiaodao.dubbotest.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cookie.liya
 * @date   Jun 24, 2017
 */
public class DubboInvocationHaldler implements InvocationHandler{
	
	private DubboInvoker<?> invoker;
	
	public DubboInvocationHaldler(DubboInvoker invoker) {
		this.invoker = invoker;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		return invoker.invoke(method.getName(), method.getParameterTypes(),args);
	}

}


