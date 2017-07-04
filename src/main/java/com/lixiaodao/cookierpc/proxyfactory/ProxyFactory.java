package com.lixiaodao.cookierpc.proxyfactory;

import com.lixiaodao.cookierpc.Url;
import com.lixiaodao.cookierpc.invoke.Invoker;

/**
 * @author cookie.liya
 * @date   Jul 3, 2017
 */
public interface ProxyFactory {
	
	<T> T getproxy(Invoker<T> invoker);
	
	<T> Invoker<T> getInvoker(T proxy,Url url,Class<T> type);
	
}


