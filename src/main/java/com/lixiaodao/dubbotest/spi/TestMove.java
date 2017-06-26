package com.lixiaodao.dubbotest.spi;

import org.junit.Test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author cookie.liya
 * @date   Jun 25, 2017
 */
public class TestMove {
	@Test
	public void testMI(){
		
		Move move = ExtensionLoader.getExtensionLoader(Move.class).getAdaptiveExtension();
		URL url = new URL("dubbo", "10.1.200.133", 12121).addParameter("move", "fly");
		move.move(url );
	}
	
}


