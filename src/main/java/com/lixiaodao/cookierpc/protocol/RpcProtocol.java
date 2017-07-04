package com.lixiaodao.cookierpc.protocol;

import com.lixiaodao.cookierpc.Exporter;
import com.lixiaodao.cookierpc.RpcExporter;
import com.lixiaodao.cookierpc.Url;
import com.lixiaodao.cookierpc.invoke.Invoker;
import com.lixiaodao.cookierpc.invoke.JvmInvoker;

/**
 * @author cookie.liya
 * @date   Jul 3, 2017
 */
public class RpcProtocol implements Protocol {

	@Override
	public <T> Exporter<T> export(Invoker<T> invoker) {
		RpcExporter<T> exportor = new RpcExporter<>();
		exportor.setInvoker(invoker);
		return export(invoker);
	}

	@Override
	public <T> Invoker<T> refer(Class<T> type, Url url) {
		JvmInvoker<T> invoker = new JvmInvoker<>();
		
		return invoker;
	}

}


