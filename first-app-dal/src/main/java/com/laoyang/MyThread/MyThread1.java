package com.laoyang.MyThread;

public class MyThread1 extends Thread {
	private Counter counter;
	 MyThread1(Counter counter){
		 this.counter=counter;
	 }
		public void run (){
			//Counter counter = new Counter();
			counter.test();
		}
}
