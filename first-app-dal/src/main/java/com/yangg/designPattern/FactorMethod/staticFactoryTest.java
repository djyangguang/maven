package com.yangg.designPattern.FactorMethod;

/**
 * 
 * @author master-hadoop
 * 1.3:静态工厂方法模式
 * 将多个工厂模式中的方法设置成静态，不需要创建实力直接使用；
 */
public class staticFactoryTest {
	public static void main (String [] args){
		
		Sender sender =staticSendFactory.productMail();
		sender.Send();
		
	}
}
