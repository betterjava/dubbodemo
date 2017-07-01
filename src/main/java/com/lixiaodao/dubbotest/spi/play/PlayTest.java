package com.lixiaodao.dubbotest.spi.play;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Test;

/**
 * @author cookie.liya
 * @date   Jul 1, 2017
 */
public class PlayTest {

	@Test
	public void testPlay(){
		/**
		 * 感觉这个扩展点  并没有什么太多的逻辑啊 ，呵呵
		 */
		ServiceLoader<Play> loader = ServiceLoader.load(Play.class);
		Iterator<Play> it = loader.iterator();
		String obj = "people";
		while(it.hasNext()){
			Play play= it.next();
			
			if(play.isSupport(obj)){
				play.play();
			}
		}
	}
}


