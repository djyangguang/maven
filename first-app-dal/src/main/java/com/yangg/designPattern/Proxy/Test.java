package com.yangg.designPattern.Proxy;
/**
 * 
 * @author master-hadoop
 * 代理模式类
 * 代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候回去找中介，为什么呢？因为你对该地区房屋的信息掌握的不够全面
	*希望找一个更熟悉的人去帮你做，此处的代理就是这个意思。再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，可以替我们进行操作，表达我们的想法
 */



public class Test {
	public static void main (String[] args){
		Source source = new Source();
		Sourceable proxy= new Proxy(source);
		proxy.method();
	}
}


//代理模式的应用场景： 
//如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法： 
//1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。 
//2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。 
//使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
//
//注意: 装饰模式和代理模式在很多情况下,大部分代码都是类似的，但是这俩种设计的意图是不一样的,装饰模式是增强被包装对象的功能,代理模式是控制被代理对象的行为
//
//例如一块代码，如果被描述为使用了装饰模式,那么我们就知道设计的意图是增加被包装对象的功能,如果被描述为使用了代理模式,那么我们就知道设计的意图是控制被代理对象的行为，
//虽然这俩种情况下他们的代码结构基本相同.
//
//1、装饰器模式：能动态的新增或组合对象的行为。 
//2、代理模式 ：为目标对象提供一种代理以便控制对这个对象的访问. 
//3、装饰模式是“新增行为”，而代理模式是“控制访问”。


//对代理模式的一些重要扩展 
//用户tom—买—>商品 
//由于各种原因导致不是很方便购买,所以就找代购 
//用户tom—找—>代购者zs—买—>商品 
//那么在代理模式中,用户tom就是目标对象,代购者zs就是代理对象 
//创建目标对象的类叫目标类或者被代理类 
//创建代理对象的类加代理类
//
//建时期，代理类可分为两种： 
//1、静态代理类： 
//由程序员创建或由特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。 
//2、动态代理类：在程序运行时，运用反射机制动态创建而成。 
//与静态代理类对照的是动态代理类，动态代理类的字节码在程序运行时由Java反射机制动态生成，无需程序员手工编写它的源代码。
//动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性，因为Java 反射机制可以生成任意类型的动态代理类。
//java.lang.reflect 包下面的Proxy类和InvocationHandler 接口提供了生成动态代理类的能力。