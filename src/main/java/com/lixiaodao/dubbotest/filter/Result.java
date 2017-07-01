package com.lixiaodao.dubbotest.filter;

/**
 * @author cookie.liya
 * @date   Jul 1, 2017
 */
public interface Result {
	
	Object getValue();
	
	
	Throwable getException();
	
	
	boolean hasException();
	
}


