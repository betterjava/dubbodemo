package com.lixiaodao.cookierpc.invoke;

/**
 * @author cookie.liya
 * @date   Jul 3, 2017
 */
public interface Invoker <T>{
	
	Class<T> getInterface();
	
	Object invoke(Invocation invocation) throws Throwable;
}


