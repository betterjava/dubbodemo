package com.lixiaodao.cookierpc.invoke;

/**
 * @author cookie.liya
 * @date   Jul 3, 2017
 */
public interface Invocation {
	
	String getMethodName();
	
	Object[] getParams();
	
	Class<?>[] getParamTypes();
}


