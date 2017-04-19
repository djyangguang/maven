package com.yangg.designPattern.Mediator;
/**
 * 
 * @author master-hadoop
 *中介者模式
 *介者模式也是用来降低类和类之间的耦合的，因为如果类和类之间有依赖关系的话，不利于功能的拓展和维护，
 *因为只要修改一个对象，其它关联的对象都得进行修改。如果使用中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行
 */
public class Test {
	public static void main (String[] args){
		
		Mediator mediator = new MyMediator();
		mediator.createmediator();
		mediator.workAll();
	}
}
//适用场景 
//在面向对象编程中，一个类必然会与其他的类发生依赖关系，完全独立的类是没有意义的。一个类同时依赖多个类的情况也相当普遍，既然存在这样的情况，说明，
//一对多的依赖关系有它的合理性，适当的使用中介者模式可以使原本凌乱的对象关系清晰，但是如果滥用，则可能会带来反的效果。
//一般来说，只有对于那种同事类之间是网状结构的关系，才会考虑使用中介者模式。可以将网状结构变为星状结构，使同事类之间的关系变的清晰一些。