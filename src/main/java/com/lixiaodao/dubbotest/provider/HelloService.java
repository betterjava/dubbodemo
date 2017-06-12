package com.lixiaodao.dubbotest.provider;

import com.lixiaodao.dubbotest.api.Hello;

public class HelloService implements Hello{

	@Override
	public void sayHello() {
		System.out.println("I am a  provider============================");
	}

}
