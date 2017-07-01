package com.lixiaodao.dubbotest.filter;

/**
 * @author cookie.liya
 * @date   Jul 1, 2017
 */
public interface Invoker<T> {
	
	 Class<T> getInterface();
	 
	 Result invoke(Invocation invocation) throws InvokeException;
}


