package com.yangg.designPattern.Proxy.CglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//产生代理对象的工厂类
public class MyCglibProxyFactory implements MethodInterceptor {  

  public Object getInstance(Class<?> c) {  
      Enhancer enhancer = new Enhancer();  
      enhancer.setSuperclass(c);  
      enhancer.setCallback(this);  
      return enhancer.create();  
  }  
  public Object intercept(Object obj, Method method, Object[] args,  
          Method proxy) throws Throwable {  

      System.out.println("开始执行方法");  
      //这句代码最终会执行到我们目标对象中的方法
      proxy.invoke(obj, args);  
      System.out.println("方法执行结束"); 

      return null; 
  }
@Override
public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
	// TODO Auto-generated method stub
	return null;
}
}
