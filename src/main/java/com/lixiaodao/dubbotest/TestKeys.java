package com.lixiaodao.dubbotest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.protocol.injvm.InjvmProtocol;
import com.alibaba.dubbo.rpc.proxy.AbstractProxyInvoker;
import com.alibaba.dubbo.rpc.proxy.InvokerInvocationHandler;
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
		
		/**
		 * ProxyFactory
		 * AbstractProxyInvoker--invoker 的一种实现
		 * InvokerInvocationHandler--真正的调用，组装proxy
		 * 
		 * 
		 * proxyfactory 通过 orginProxy 可以生成invoker --invoker 宝行 orginProxy 和  interface 信息
		 * 
		 * proxyfactory 通过 invoker 可以生成 proxy -- 这个proxy 是有 proxy.newInstance()生成的，其中 方法调用  InvokerInvocationHandler 持有 invoker 的因为，在 invoke 方法中，会调用 invoker.invoke 方法，
		 * 																																AbstractProxyInvoker.invoke 会 调用 抽象方法 doInvode
		 */
	}
	@Test
	public void testInvoke(){
		Hello orginProxy = getHello();
		
		AbstractProxyInvoker invoker = new AbstractProxyInvoker(orginProxy, Hello.class, null) {
			
			@Override
			protected Object doInvoke(Object proxy, String methodName, Class[] parameterTypes, Object[] arguments) throws Throwable {
				Method method = proxy.getClass().getMethod(methodName, parameterTypes);
				return method.invoke(proxy, arguments);
			}
		};
		
		Hello proxy = (Hello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Hello.class}, new InvokerInvocationHandler(invoker));
		proxy.sayHello();
	}
	
	@Test
	public void testProtocol() {
		ProxyFactory proxyFactory = getProxyFactory();
		Hello orginProxy = getHello();
		Class<Hello> type = Hello.class;
		URL url = new URL("injvm", "127.0.0.1", 12345).setServiceInterface("com.lixiaodao.dubbotest.api.Hello");
		Invoker<Hello> invoker = proxyFactory.getInvoker(orginProxy, type, url);// AbstractProxyInvoker  
		// 以上 invoker 就已经生成了
		InjvmProtocol injvmProtocol = new InjvmProtocol();
		Exporter<Hello> exportor = injvmProtocol.export(invoker);
		
		// 引用的时候，是首先获得一个invoker--重点是 如何找到这个invoker invoker =
		// refprotocol.refer(interfaceClass, url);
		// 然后 proxyfactory.getProxy(invoker)
		
		
		//============我是分界线=============
		InjvmProtocol injvmProtocolConsumer = InjvmProtocol.getInjvmProtocol();
		ProxyFactory proxyFactoryConsumer = getProxyFactory();
		
		Invoker<Hello> referInvoker = injvmProtocolConsumer.refer(Hello.class, url); // InjvmInvoker --通过 map 获取 exportor ，export 中有invoker 的引用，最后会调用  AbstractProxyInvoker
		Hello proxy = proxyFactoryConsumer.getProxy(referInvoker);
		proxy.sayHello();
	}
	
	@Test
	public void testDubboInvo() throws InterruptedException{
		ProxyFactory proxyFactory = getProxyFactory();
		Hello orginProxy = getHello();
		Class<Hello> type = Hello.class;
		URL url = new URL("dubbo", "10.1.193.113", 12345).setServiceInterface("com.lixiaodao.dubbotest.api.Hello");
		Invoker<Hello> invoker = proxyFactory.getInvoker(orginProxy, type, url); // AbstractProxyInvoker  
		
		DubboProtocol dubboProtocol = getDubboProtocol();
		dubboProtocol.export(invoker);
		
		DubboProtocol consumerProtocol = new DubboProtocol();
		
		Invoker<Hello> referInvoker = consumerProtocol.refer(Hello.class, url);// 这儿是生成一个 dubboinvoker，把Url 编程这个dubboinvoker 持有的 连接，invoke ，就被变成了去远程调用
		ProxyFactory  consumerProxyFactory = getProxyFactory();
		Hello proxy = consumerProxyFactory.getProxy(referInvoker);
		try {
			proxy.sayHello();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			Thread.currentThread().sleep(1000);
		}
	}

	
	private static DubboProtocol getDubboProtocol() {
		return new DubboProtocol();
	}
	
	
	@
	
	
}
