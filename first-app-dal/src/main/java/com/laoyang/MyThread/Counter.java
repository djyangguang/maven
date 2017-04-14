 package com.laoyang.MyThread;

public class Counter  {
	private int count =0;
	public int getCount(){
		return count;
	}
	public   synchronized void addCount(){
		count++;
		
	}
	
	
	public synchronized void test(){
		System.out.println("1");
		try {
			Thread.sleep(1000);//实际的业务操作 需要一定的时间;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2");
		
	}

}
