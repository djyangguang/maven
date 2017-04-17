package com.yangg.designPattern.Decorator;
//抽象的装饰类
public abstract class Decorator implements Action {
	private Action action;
	public Decorator (Action action){
		this.action=action;
		
	}
	public void go(){
		this.action.go();
	}
	
}
