package com.lixiaodao.dubbotest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.protocol.injvm.InjvmProtocol;
import com.alibaba.dubbo.rpc.proxy.jdk.JdkProxyFactory;
import com.lixiaodao.dubbotest.api.Hello;

/**
 * @author cookie.liya
 * @date Jun 24, 2017
 */
public class TestKeys {

	private static ProxyFactory getProxyFactory() {
		return new JdkProxyFactory();
	}

	private static Protocol getProtocol() {
		return new InjvmProtocol();
	}

	private static Hello getHello() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dubbo.xml");
		Hello hello = (Hello) applicationContext.getBean("helloService");
		return hello;
	}

	@Test
	public void testProxyFactoryProtocol() {
		ProxyFactory proxyFactory = getProxyFactory();
		Hello orginProxy = getHello();
		Class<Hello> type = Hello.class;
		URL url = new URL("injvm", "127.0.0.1", 12345);
		Invoker<Hello> invoker = proxyFactory.getInvoker(orginProxy, type, url);
		Hello proxy = proxyFactory.getProxy(invoker);
		proxy.sayHello();
	}
}
