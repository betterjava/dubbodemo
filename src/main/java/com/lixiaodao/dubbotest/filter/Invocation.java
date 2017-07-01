package com.lixiaodao.dubbotest.filter;

/**
 * @author cookie.liya
 * @date Jul 1, 2017
 */
public interface Invocation {

	String getMethodName();

	Class<?>[] getParameterTypes();

	Object[] getArguments();

	Invoker<?> getInvoker();
}
