package com.yangg.designPattern.Proxy.staticProxy;
//委托类
public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
			System.out.println("hello world");
	}

}
