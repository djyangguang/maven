package com.laoyang.MyThread;

public class Main1 {
	public static void main (String[] args){
		Counter counter = new Counter();
		for (int i =0;i< 3 ;i++){
			Thread thread = new MyThread1(counter);
			thread.start();

		}
	}
}
