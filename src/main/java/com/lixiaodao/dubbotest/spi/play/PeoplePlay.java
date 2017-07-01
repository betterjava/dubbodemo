package com.lixiaodao.dubbotest.spi.play;

/**
 * @author cookie.liya
 * @date   Jul 1, 2017
 */
public class PeoplePlay implements Play{

	@Override
	public void play() {
		System.out.println("people playing");
	}

	@Override
	public boolean isSupport(String obj) {
		return obj.equals("people");
	}

}


