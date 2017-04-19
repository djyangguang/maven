package com.yangg.designPattern.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{
	private Object target;
	private StudentLogger logger = new StudentLogger();
	public MyHandler(Object target,StudentLogger logger){
		this.target=target;
		this.logger=logger;
	}
	public MyHandler(Object target){
		this.target=target;
	}
	@Override
	//参数1 proxy  将来给目标对象所动态产生的代理对象
    //参数2 method 将来你所调用的目标对象中的方法的镜像
    //参数3 args       将来你所调用方法的时候所传的参数
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String msg= method.getName()+"方法内调用了";
		logger.log(msg);
		Object o = method.invoke(target, args);
		return o;
	}

}
