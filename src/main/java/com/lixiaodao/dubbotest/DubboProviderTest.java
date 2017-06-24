package com.lixiaodao.dubbotest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.lixiaodao.dubbotest.api.Hello;

public class DubboProviderTest {

	@Test
	public void startaProvider() {
		
		 ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dubbo.xml");
		
		 Hello hello = (Hello) applicationContext.getBean("helloService");
		
		ApplicationConfig application = new ApplicationConfig();
		application.setName("xxx");
		 
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://10.1.200.134:2181");
//		registry.setAddress("N/A");
//		registry.setAddress("zookeeper://10.1.200.134:2181");
//		registry.setAddress("zookeeper://10.1.200.134:2181");
		 
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
//		protocol.setName("injvm");
		protocol.setPort(12345);
		protocol.setThreads(200);
		 
		 
		ServiceConfig<Hello> service = new ServiceConfig<Hello>(); 
		service.setApplication(application);
		service.setRegistry(registry);
		service.setProtocol(protocol);
		service.setInterface(Hello.class);
		service.setRef(hello);
		service.setVersion("1.0.0");
		 
		service.export();
		
		while(true){
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void startaProviderLocal() {
		
		 ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dubbo.xml");
		
		 Hello hello = (Hello) applicationContext.getBean("helloService");
		
		ApplicationConfig application = new ApplicationConfig();
		application.setName("xxx");
		 
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("N/A");
		 
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("injvm");
		protocol.setPort(12345);
		protocol.setThreads(200);
		 
		 
		ServiceConfig<Hello> service = new ServiceConfig<Hello>(); 
		service.setApplication(application);
		service.setRegistry(registry);
		service.setProtocol(protocol);
		service.setInterface(Hello.class);
		service.setRef(hello);
		service.setVersion("1.0.0");
		 
		service.export();
		
		while(true){
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
