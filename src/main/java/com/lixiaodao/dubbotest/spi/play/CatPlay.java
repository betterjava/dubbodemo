package com.lixiaodao.dubbotest.spi.play;

/**
 * @author cookie.liya
 * @date   Jul 1, 2017
 */
public class CatPlay implements Play {

	@Override
	public void play() {
		System.out.println(" cat is playing");
	}

	@Override
	public boolean isSupport(String obj) {
		return obj.equals("cat");
	}

}


