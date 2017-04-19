package com.yangg.designPattern.Bridge;
/**
 * 
 * @author master-hadoop
 * 桥接模式
 *测试类  注意我们的抽象和具体实现是分开的,无论他们如何变化都不会影响到我们bridge中的功能执行
 	JDBC中,我们使用的就是一系列javaAPI提供的接口,而且数据公司商则给我们提供接口的实现
 */
public class Test {
	public static void main (String [] args){
		DriverManager manager = new DriverManager(new MysqlDriver());
		manager.getConnection();
		manager = new DriverManager(new OracleDriver());
		manager.getConnection();
	}
}
//桥接模式（也叫桥梁模式）就是将抽象部分和实现部分分离，使它们都可以独立的变化。桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，
//在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。