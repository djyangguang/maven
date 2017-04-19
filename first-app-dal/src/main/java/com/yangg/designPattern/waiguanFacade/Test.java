package com.yangg.designPattern.waiguanFacade;
/**
 * 
 * @author master-hadoop
 *外观/门面模式
 *为子系统或者模块中的一组接口提供一个一致的访问方式，此模式定义了一个高层接口，这个接口使得各个子系统/模块中的功能更加容易使用。 
实际应用中，我们在对付一些老旧的代码或者即便不是老旧code，但涉及多个子系统时，除了重写全部代码，我们还可能采用这样一种策略：重新进行类的设计，
将原来分散在源码中的类/结构及方法重新组合，形成新的、统一的接口，供上层应用使用,同时也隐藏了子系统或者子模块中功能实现的复杂性
 */
public class Test {
	public static void main (String [] args){
		waiguanFacade f = new waiguanFacade();
		f.service();
	}
}
//Facade是我们的外观类/门面类,用户可以通过这个类使用到系统中不同模块中的不同方法，同时也对用户隐藏了系统中对这些功能的实现细节。给用户提供了一个统一的访问方式。
