package com.lixiaodao.dubbotest.spi.impl;

import com.alibaba.dubbo.common.URL;
import com.lixiaodao.dubbotest.spi.Move;

/**
 * @author cookie.liya
 * @date   Jun 25, 2017
 */
public class Fly implements Move {

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(URL url) {
		System.out.println("I am flying");
	}


}


