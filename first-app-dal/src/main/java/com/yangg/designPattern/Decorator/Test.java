package com.yangg.designPattern.Decorator;
/**
 * 
 * @author master-hadoop
 *装饰器模式
 *1、需要扩展一个类的功能。 
2、动态的为一个对象增加功能，而且还能动态撤销。 
缺点：产生过多相似的对象，不易排错！
 */
public class Test {
	//可以根据需求 任意的给go方法添加听音乐或者休息的功能
	public static  void main (String[] args){
		//Action a = new Person();
	    //Action a = new ListenDecorator(new Person());
	    //Action a = new RelaxDecorator(new Person());
	    //Action a = new RelaxDecorator(new ListenDecorator(new Person()));
		Action a= new ListenDecotator(new RelaxDecorator(new Person()));
		a.go();
	}
}
