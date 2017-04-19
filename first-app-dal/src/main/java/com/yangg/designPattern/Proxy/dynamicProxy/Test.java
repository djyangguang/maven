package com.yangg.designPattern.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * 
 * @author master-hadoop
 *动态代理类
 */
public class Test {
	public static void main (String[] args){
		IStudentService  target = new StudentServiceImpl();
		ClassLoader loader =target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new MyHandler(target);

        //参数1 loader        目标对象的类加载器
        //参数2 interfaces    目标对象所实现的接口
        //参数3 h         InvocationHandler接口的实现类对象
        IStudentService proxy = (IStudentService)Proxy.newProxyInstance(loader, interfaces, h);

        proxy.delete(1);
        proxy.save(null);
        proxy.find(1);

        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(target.getClass());
	}
}

//在程序运行时，运用反射机制动态创建而成。 
//与静态代理类对照的是动态代理类，动态代理类的字节码在程序运行时由Java反射机制动态生成，无需程序员手工编写它的源代码。动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性，
//因为Java 反射机制可以生成任意类型的动态代理类。java.lang.reflect 包下面的Proxy类和InvocationHandler 接口提供了生成动态代理类的能力。
