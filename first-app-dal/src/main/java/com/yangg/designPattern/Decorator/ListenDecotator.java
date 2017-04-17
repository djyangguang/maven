package com.yangg.designPattern.Decorator;

public class ListenDecotator extends Decorator {

	public ListenDecotator(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	public void go(){
		listen();//添加一个听音乐的功能
		super.go();
		
	}
	public void listen(){
		
		System.out.println("我在听歌");
	}

	
}
