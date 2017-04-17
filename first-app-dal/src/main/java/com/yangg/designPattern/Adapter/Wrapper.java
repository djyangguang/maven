package com.yangg.designPattern.Adapter;

public class Wrapper implements Tatgetable {
	private Source source;
	public Wrapper(Source source){
		this.source=source;
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");
		
	}

	@Override
	//这是重点
	public void method2() {
		// TODO Auto-generated method stub
		source.method1();
	}

}
