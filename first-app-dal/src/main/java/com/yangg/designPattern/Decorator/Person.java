package com.yangg.designPattern.Decorator;
//被装饰的类，就是需要我们装饰的目标
public class Person implements Action{

	@Override
	public void go() {
		// TODO Auto-generated method stub
		System.out.println("我在周咯");
	}

}
