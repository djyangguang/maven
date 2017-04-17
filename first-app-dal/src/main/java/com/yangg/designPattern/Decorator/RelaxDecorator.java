package com.yangg.designPattern.Decorator;

public class RelaxDecorator extends Decorator {

	public RelaxDecorator(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	public void go (){
		super.go();
		relax();
	}
	public void relax(){
		System.out.println("我在休息");
	}

}
