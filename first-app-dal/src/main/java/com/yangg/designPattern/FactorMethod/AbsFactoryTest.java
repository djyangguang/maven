package com.yangg.designPattern.FactorMethod;
/**
 * 
 * @author master-hadoop
 * 抽象工厂模式
 * 工厂方法有个问题：类的创建依赖工厂类，如果香拓展程序必须对工厂类进行修改，这违背了闭包原则，
 * 就用抽象工厂模式，一旦需要新增新的功能 直接新增新的工厂类级乐意了
 * 
 * 这个模式的好处就是，如果你现在想增加一个功能：发送及时信息，则只需做一个实现类实现Sender接口，
 * 同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好
 */
public class AbsFactoryTest {
	public static void main (String [] args){
		
		Provider provider = new SendMailFactory();
		Sender sender = provider.priduct();
		sender.Send();
	}
}
