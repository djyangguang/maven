package com.yangg.designPattern.State;
/**
 * 
 * @author master-hadoop
 *状态模式
 *
 *核心思想就是：当对象的状态改变时，同时改变其行为，很好理解！就拿QQ来说，有几种状态，在线、隐身、忙碌等，每个状态对应不同的操作。再比如交通灯，有红黄绿三种状态，每种状态下操作也是不一样的
 */
public class Test {
	public static void main (String[] args){
		State state = new State();
		Context context = new Context(state);
		state.setValue("state1");
		context.method();
		state.setValue("state2");
		context.method();
	}
}
