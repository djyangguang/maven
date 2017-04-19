package com.yangg.designPattern.Proxy.staticProxy;
//代理类
public class HelloserviceProxy implements HelloService{
	private HelloService target;
	public HelloserviceProxy(HelloService target){
		this.target=target;
		
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("mahsng zhixing");
		target.sayHello();
	}

}
