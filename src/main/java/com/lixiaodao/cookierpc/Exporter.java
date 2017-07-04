package com.lixiaodao.cookierpc;

import com.lixiaodao.cookierpc.invoke.Invoker;

/**
 * @author cookie.liya
 * @date Jul 3, 2017
 */
public interface Exporter<T> {

	Invoker<T> getInvoker();

}
