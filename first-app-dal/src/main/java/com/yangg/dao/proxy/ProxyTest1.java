package com.yangg.dao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 使用动态代理不能回滚
 * jdk
 * cjlib
 * @author dj
 *
 */

public class ProxyTest1 implements  InvocationHandler {
	private TestInterface orgiInterface;
	public ProxyTest1(TestInterface test){
		this.orgiInterface=test;
	}
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if(arg1.getName().startsWith("test")){
			System.out.println("______________proxy output_________________");
		}
		return arg1.invoke(orgiInterface, args);//在原始的对象上执行
		//原始对象在代理方法的时候
	}
	//创建按一个代理
	public TestInterface createProxy(){
		
		
		return (TestInterface)Proxy.newProxyInstance(ProxyTest1.class.getClassLoader(), 
				new Class[]{TestInterface.class}, this);
		
		
	}
	public static void main (String[] args){
//		TestInterFaceImpl orginal = new TestInterFaceImpl();
//		ProxyTest1 ptoxytest = new ProxyTest1(orginal);
//		TestInterface proxy = ptoxytest.createProxy();
//		proxy.test();
//		proxy.test1();
//		proxy.test2();
		/**
		 * ______________proxy output_________________
				++++test
			______________proxy output_________________
				++====++test2
			______________proxy output_________________
				++++test3
		这样是走代理的
		 */
		TestInterFaceImpl orginal = new TestInterFaceImpl();
		ProxyTest1 ptoxytest = new ProxyTest1(orginal);
		TestInterface proxy = ptoxytest.createProxy();
		proxy.test();
		//proxy.test1();//如果test1()在test()中那么test1() 走不了代理了
		proxy.test2();
		/**
		 * ______________proxy output_________________
		++====++test2
			++++test
		______________proxy output_________________
			++++test3

		 */
	}

}
