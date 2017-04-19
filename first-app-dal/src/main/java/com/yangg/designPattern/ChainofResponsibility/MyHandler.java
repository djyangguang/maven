package com.yangg.designPattern.ChainofResponsibility;

public class MyHandler implements Handler {
	private String name;
	private Handler handler;
	public MyHandler(String name){
		this.name=name;
	}
	public Handler getHandler(){
		return handler;
	}
	public void setHandler(Handler handler){
		this.handler=handler;
	}
	@Override
	public void operator() {
		// TODO Auto-generated method stub
		System.out.println("name="+name);
		if(getHandler()!=null){
			getHandler().operator();
		}
	}

}
