package com.lixiaodao.dubbotest;

import org.junit.Test;

import com.alibaba.dubbo.container.Main;

public class TestDubo {
	
	@Test
	public void testSome(){
		System.out.println("hello");
	}
	
	@Test
	public void startDubbo(){
		String[] args = new String[]{};
		Main.main(args );
	}
}
