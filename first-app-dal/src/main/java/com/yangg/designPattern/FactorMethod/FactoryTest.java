package com.yangg.designPattern.FactorMethod;

import net.sf.cglib.proxy.Factory;
/**
 * 
 * @author master-hadoop
 * 1.1普通工场模式：
 * 就是建立一个工厂类；对实现了同一个接口的产品类进行实力的创建；
 */
public class FactoryTest {
	public static void main (String[] args){
		
		SendFactory factory = new SendFactory();
		Sender sender =factory.product("sms");
		sender.Send();
	}
}
