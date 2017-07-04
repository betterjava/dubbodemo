package com.lixiaodao.cookierpc.protocol;

import com.lixiaodao.cookierpc.Exporter;
import com.lixiaodao.cookierpc.Url;
import com.lixiaodao.cookierpc.invoke.Invoker;

/**
 * @author cookie.liya
 * @param <T>
 * @date   Jul 3, 2017
 */
public interface Protocol {
	
	<T> Exporter<T> export(Invoker<T> invoker);
	
	<T> Invoker<T> refer(Class<T> type,Url url);
}


