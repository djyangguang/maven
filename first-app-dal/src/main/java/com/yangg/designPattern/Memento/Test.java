package com.yangg.designPattern.Memento;
/**
 * 
 * @author master-hadoop
 *备忘录模式
 */
public class Test {
	public static void main (String [] args){
		Original origi = new Original("egg");
		Storage storage = new Storage(origi.createMemento());
		System.out.println("初始化的状态："+origi.getValue());
		origi.setValue("niu");
		System.out.println("修改后的状态："+origi.getValue());
		//回复原来的状态
		origi.restoreMemento(storage.getMemento());
		System.out.println("回复原来的状态："+origi.getValue());
		//
		
	}
}
//也可以叫备份模式，主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象：
//假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。