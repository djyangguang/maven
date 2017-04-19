package com.yangg.designPattern.Observer;
//我们自己的一个被观察者实现 里面可以有我们自己的各种属性何方法
public  class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("update self");
		notifyObserver();
	}
//	public void operation(){
//		System.out.println("update self");
//		notifyObservers();
//	}

	
}
