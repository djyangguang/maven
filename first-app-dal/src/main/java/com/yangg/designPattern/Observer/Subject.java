package com.yangg.designPattern.Observer;
//被观察者
public interface Subject {
	//增加观察者模式
		public void add (Observer observer);
		//删除观察者模式
		public void del(Observer observer);
		//通知所哟的消费者
		public void notifyObserver();
			//自身操作
		public void operation();
		
}	
