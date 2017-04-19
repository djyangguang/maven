package com.yangg.designPattern.template;
/**
 * ]
 * @author master-hadoop
 *模板方法模式
 */
public class Test {
	public static void main (String [] args){
		String exp ="8+8";
		AbstractCalculator cal = new Plus();
		int result =cal.calculate(exp, "\\+");
		System.out.println(result);
	}
}
//模板方法模式，就是指：一个抽象类中，有一个主方法，再定义1…n个方法，可以是抽象的，也可以是实际的方法，
//定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类的方法，实现对子类的调用 
//其实就是我们之前所说的: 
//子类重新/实现父类中的方法,那么调用该方法的时候则是调用到了子类中重写之后的方法