package com.yangg.designPattern.FactorMethod;

/**
 * 
 * @author master-hadoop
 * 1.2:多个工厂方法模式
 * 对普通工厂方法的改进，在普通工厂模式中，如果传递的字符串出错，则不能正确的创建对象，
 * 而多个工厂模式是提供多个工厂方法，分别创建对象；
 */
public class duogeFactoryTest {
	public static void main (String[] args){
		
		duogeSendFactory factory = new duogeSendFactory();
		Sender sender = factory.prodictSms();
		sender.Send();
	}
}
