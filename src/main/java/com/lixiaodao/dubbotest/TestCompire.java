package com.lixiaodao.dubbotest;

import com.alibaba.dubbo.common.compiler.support.AdaptiveCompiler;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.rpc.filter.EchoFilter;

import org.junit.Test;

/**
 * @author cookie.liya
 * @date   Jun 25, 2017
 */
public class TestCompire {

	@Test
	public void testAnno(){
		boolean has = AdaptiveCompiler.class.isAnnotationPresent(Adaptive.class);
		System.out.println(has);
		
		Adaptive result = AdaptiveCompiler.class.getAnnotation(Adaptive.class);
		System.out.println(result);
	}
	
	@Test
	public void testEchoFilter(){
		boolean has = EchoFilter.class.isAnnotationPresent(Adaptive.class);
		System.out.println(has);
		
		Adaptive result = EchoFilter.class.getAnnotation(Adaptive.class);
		System.out.println(result);
		
	}
}


