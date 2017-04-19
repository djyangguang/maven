package com.yangg.designPattern.Proxy.staticProxy;
/**
 * 
 * @author master-hadoop
 *静态代理
 */
public class Test {
	public static void main (String[] args){
		//目标对象	
		HelloService target = new HelloServiceImpl();
		//代理对象
		HelloService proxy = new HelloserviceProxy(target);
		proxy.sayHello();
	}
}
//由程序员创建或由特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。 