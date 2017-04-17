package com.yangg.designPattern.FactorMethod;
//单例 饿汉模式
public class Singleton {
	//持有私有静态实例，防止被引用
	private static Singleton instance = new Singleton();
	//私有的构造方法,防止被实例华
	private Singleton(){
		
	}
	//返回Singleton实力
	public static Singleton getInstance(){
		return instance;
	}
	//如果该对象被用于序列化，可以保证在序列化前后保持一致
	private Object readResolve(){
		return instance;
		
	}
	//这个类是可以实现单例模式的，但是存在不少问题,比如在类中不管用户是否要使用该类的对象,
	//就先创建好了一个实例放在内存中。

}
