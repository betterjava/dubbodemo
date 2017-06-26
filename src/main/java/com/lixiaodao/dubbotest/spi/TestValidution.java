package com.lixiaodao.dubbotest.spi;

import org.junit.Test;

import com.alibaba.dubbo.cache.Cache;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.monitor.MonitorFactory;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.validation.Validation;

/**
 * @author cookie.liya
 * @date   Jun 25, 2017
 */
public class TestValidution {

	@Test
	public void testVali(){
		Validation validation = ExtensionLoader.getExtensionLoader(Validation.class).getAdaptiveExtension();
		System.out.println(validation);
	}
	
	@Test
	public void testProtocol(){
		Protocol porProtocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
		System.out.println(porProtocol);
	}
	
	@Test
	public void testCache(){
		Cache cache = ExtensionLoader.getExtensionLoader(Cache.class).getAdaptiveExtension();
		System.out.println(cache);
		cache.put("cookie", "china");
		System.out.println(cache.get("cookie"));
	}
	
	@Test
	public void testDubboMOnitorfa(){
		MonitorFactory monitorFactory = ExtensionLoader.getExtensionLoader(MonitorFactory.class).getAdaptiveExtension();
		System.out.println(monitorFactory);
		
	}
}


