package com.laoyang.MyThread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyThread  implements Runnable {

	
	/*private static ThreadLocal<Integer> num = new ThreadLocal<Integer>(); //线程安全的每个线程一个副本
	@Override
	public void run() {
		// TODO Auto-generated method stub
		num.set(0);
		for(int i=0;i<3;i++){
			num.set(num.get()+1);
			System.out.println(Thread.currentThread().getName()+num.get());
		}
	}
	
	public static void main (String[] args){
		MyThread thread= new MyThread();
		Thread t1 = new Thread(thread,"t1");
		Thread  t2 =new Thread (thread,"t2");
		Thread t3 = new Thread (thread,"t3");
		t1.start();
		t2.start();
		t3.start();
 		
	}*/
	private List<Object> list;
	private CountDownLatch countDownLatch;
	MyThread(List<Object> list,CountDownLatch countDownLatch){
		this.list=list;
		this.countDownLatch=countDownLatch;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//每个线程想list添加100个元素
		for (int i=0;i<100;i++){
			list.add(new Object());
		}
		countDownLatch.countDown();//等待100次循环完成在继续
		
	}

}
