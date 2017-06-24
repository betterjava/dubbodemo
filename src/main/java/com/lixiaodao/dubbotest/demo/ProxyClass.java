package com.lixiaodao.dubbotest.demo;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiaodao.dubbotest.api.Hello;

/**
 * @author cookie.liya
 * @date Jun 24, 2017
 */
public class ProxyClass {
	@Test
	public void testDome() {

		Hello orginProxy = getHello();
		
		DubboInvoker<Hello> invoker = new DubboInvoker<Hello>(orginProxy, Hello.class);
		
		Hello hello = (Hello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Hello.class}, new DubboInvocationHaldler(invoker));
		
		hello.sayHello();
		
	}
	
	private static Hello getHello() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dubbo.xml");
		Hello hello = (Hello) applicationContext.getBean("helloService");
		return hello;
	}
}
