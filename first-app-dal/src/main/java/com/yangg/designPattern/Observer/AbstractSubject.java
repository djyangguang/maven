package com.yangg.designPattern.Observer;

import java.util.Iterator;
import java.util.Vector;
 
//被观rr察者的一个抽象实现  提供基本的实现
public abstract class AbstractSubject implements Subject {
	private Vector<Observer> verctor = new Vector<Observer>();
	
	public void add(Observer observer){
		verctor.add(observer);
	}
	public void del(Observer observer){
		verctor.remove(observer);
	}
	public void notifyObserver(){
		Iterator<Observer> it =verctor.iterator();
				while(it.hasNext()){
					Observer next =it.next();
					next.update();
				}
		
	}
	
	
	
	
	
	
}
