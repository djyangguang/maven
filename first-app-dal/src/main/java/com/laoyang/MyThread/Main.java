package com.laoyang.MyThread;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
/**
 * 
 * @author master-hadoop
 * list 与 Vector 比较：
 * 1： 开1000个子线程
 * 2：每一个线程想Mythread()中的list当中添加100个元素 1000*100
 * 3：用list 是不安全的线程结果错误;
 * 4：用Vector是安全的线程结果为10000；
 * 5： Vector 是synchronized 效率低
 *6：用Main1.java
 */
public class Main {
	
	public static void main (String[] args){
		//光用list是线程不安全的是动态扩容的 在不断向里面添加的时候 扩容操作还没成功执行的时候;
		// 就会出现异常 
		//List<Object> list = new ArrayList<Object>();//这样线程不安全结果错误
		List<Object> list = new Vector<Object>();
		int threadCount =1000;
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		for (int i =0;i<threadCount;i++){
			Thread thread = new Thread(new MyThread(list,countDownLatch));
			thread.start();
			
	
	}
		//主线程等待所有的子线程执行完成，在向下执行
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
	
	
}
}
