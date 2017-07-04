package com.lixiaodao.cookierpc;

import com.lixiaodao.cookierpc.invoke.Invoker;

/**
 * @author cookie.liya
 * @date Jul 3, 2017
 */
public class RpcExporter<T> implements Exporter<T> {

	private Invoker<T> invoker;

	public void setInvoker(Invoker<T> invoker) {
		this.invoker = invoker;
	}

	@Override
	public Invoker<T> getInvoker() {
		return invoker;
	}

}
