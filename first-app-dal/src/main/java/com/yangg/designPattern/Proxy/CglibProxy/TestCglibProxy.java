package com.yangg.designPattern.Proxy.CglibProxy;
/**
 * 
 * @author master-hadoop
 *第三方jar包提供的动态代理(cglib) CglibProxy
 */
public class TestCglibProxy {
	public static void main(String[] args) {  
        MyCglibProxyFactory cglib=new MyCglibProxyFactory();  
        BookService bookCglib= 
            (BookService)cglib.getInstance(new BookService().getClass());  

        bookCglib.addBook();  
        System.out.println(bookCglib.getClass());
    }  
}

//CGLib代理(第三方类库)
//JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，这就需要CGLib了。CGLib    采用了非常底层的字节码技术，其原理是通过字节码技术为目标对象创建一个子类对象，并在子类对象中拦截所有父类方法的调用，然后在方法调用前后调用后都可以加入自己想要执行的代码。
//需要这种方法只是需要俩个第三方jar包: cglib-3.2.1.jar和asm-5.0.4.jar
//同时很多框架已经把这些jar包整合到一起了，比如spring框架的spring-core-3.2.4.RELEASE.jar,这一个jar包就包括上述俩个jar包的大多数功能
