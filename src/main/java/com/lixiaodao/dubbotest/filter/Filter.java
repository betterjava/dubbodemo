package com.lixiaodao.dubbotest.filter;

/**
 * @author cookie.liya
 * @date Jul 1, 2017
 */
public interface Filter {
	
	Result invoke(Invoker<?> invoker, Invocation invocation) throws InvokeException;
	
	
}
