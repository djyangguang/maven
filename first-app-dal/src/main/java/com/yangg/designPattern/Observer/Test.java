package com.yangg.designPattern.Observer;
/**
 * 
 * @author master-hadoop
 * 观察者模式
 * 观察者模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客时，
 * 经常会看到RSS图标，就这的意思是，当你订阅了该文章，如果后续有更新，
 * 会及时通知你。其实，简单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，
 * 并且随着变化！对象之间是一种一对多的关系。 
	我们在GUI那一章学习的事件监听机制就是可以这种设置模式来构建的代码
 */
public class Test {
	public static void main(String[] args){
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		sub.operation();
	}
}
