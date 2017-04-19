package com.yangg.designPattern.waiguanFacade;

public class waiguanFacade {
	private ServiceA a;
	private ServiceB b;
	private ServiceC c;
	
	public waiguanFacade(){
		a= new  ServiceA();
		b= new ServiceB();
		c= new ServiceC();
		
	}
	public void start(){
		a.start();
	}
	public void run(){
		b.run();
	}
	public void end(){
		c.end();
	}
	public void service(){
		
		a.start();
		b.run();
		c.end();
	}
}
