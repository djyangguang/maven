package com.yangg.designPattern.Proxy;
//代理类
public class Proxy implements Sourceable {
	private Source source;
	public  Proxy(Source source){
		this.source=source;
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		source.method();
		atfer();
	}
	private void before(){
		System.out.println("before");
	}
	private void atfer(){
		
		System.out.println("atfer");
	}

}
