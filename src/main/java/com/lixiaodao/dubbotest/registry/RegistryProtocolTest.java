package com.lixiaodao.dubbotest.registry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.integration.RegistryProtocol;
import com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistryFactory;
import com.alibaba.dubbo.remoting.zookeeper.zkclient.ZkclientZookeeperTransporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.proxy.jdk.JdkProxyFactory;
import com.lixiaodao.dubbotest.api.Hello;

/**
 * @author cookie.liya
 * @date Jun 25, 2017
 */
public class RegistryProtocolTest {

	private static Hello orginonProxy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dubbo.xml");
		orginonProxy = (Hello) applicationContext.getBean("helloService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProtocal() {
		URL url = URL.valueOf("registry://10.1.200.134:2181/com.alibaba.dubbo.registry.RegistryService?application=xxx&dubbo=2.5.3&export=dubbo%3A%2F%2F10.1.193.113%3A12345%2Fcom.lixiaodao.dubbotest.api.Hello%3Fanyhost%3Dtrue%26application%3Dxxx%26dubbo%3D2.5.3%26interface%3Dcom.lixiaodao.dubbotest.api.Hello%26methods%3DsayHello%26pid%3D6692%26revision%3D1.0.0%26side%3Dprovider%26threads%3D200%26timestamp%3D1498370268049%26version%3D1.0.0&pid=6692&registry=zookeeper&timestamp=1498370268017");
		
		ProxyFactory proxyFactory = new JdkProxyFactory();
		Invoker<Hello> originInvoker = proxyFactory.getInvoker(orginonProxy, Hello.class, url);
		RegistryProtocol protocol = new RegistryProtocol();
		ZookeeperRegistryFactory zookeeperRegistryFactory = new ZookeeperRegistryFactory();
		zookeeperRegistryFactory.setZookeeperTransporter(new ZkclientZookeeperTransporter());
		protocol.setRegistryFactory(zookeeperRegistryFactory);
		protocol.setProtocol(new DubboProtocol());
		protocol.export(originInvoker);
		
		//-------------------------分割线-----------------
		
		RegistryProtocol consumerProtocol = new RegistryProtocol();
		ZookeeperRegistryFactory zookeeperRegistryFactory1 = new ZookeeperRegistryFactory();
		zookeeperRegistryFactory.setZookeeperTransporter(new ZkclientZookeeperTransporter());
		consumerProtocol.setRegistryFactory(zookeeperRegistryFactory1);
		consumerProtocol.setProtocol(new DubboProtocol());
		consumerProtocol.setCluster(new FailoverCluster());
		
		
		URL consumerUrl = URL.valueOf("registry://10.1.200.134:2181/com.alibaba.dubbo.registry.RegistryService?application=yyy&dubbo=2.5.3&pid=6852&refer=application%3Dyyy%26dubbo%3D2.5.3%26interface%3Dcom.lixiaodao.dubbotest.api.Hello%26methods%3DsayHello%26pid%3D6852%26revision%3D1.0.0%26side%3Dconsumer%26timestamp%3D1498373066869%26version%3D1.0.0&registry=zookeeper&timestamp=1498373084845");
		Invoker<Hello> cousumerInvoder = consumerProtocol.refer(Hello.class, consumerUrl);
		
		ProxyFactory cousumerProxyFactory = new JdkProxyFactory();
		Hello proxy = cousumerProxyFactory.getProxy(cousumerInvoder);
		proxy.sayHello();
	}

}
