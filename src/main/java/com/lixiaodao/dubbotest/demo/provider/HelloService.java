package com.lixiaodao.dubbotest.demo.provider;

import com.lixiaodao.dubbotest.demo.api.Hello;

public class HelloService implements Hello{

	@Override
	public void sayHello() {
		System.out.println("I am a  provider============================");
	}

}
