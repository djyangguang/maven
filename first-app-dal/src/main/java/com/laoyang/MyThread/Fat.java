package com.laoyang.MyThread;

public class Fat
{
	private volatile double d;
	private static int counter = 0;
	private final int id = counter++;

	public Fat()
	{
		// expensive, interruptible operation: 昂贵的，可中断的操作
		for (int i = 1; i < 10000; i++)
		{
			d += (Math.PI + Math.E) / (double) i;
		}
	}

	public void operation()
	{
		System.out.println("operation>>  "+this);
	}

	@Override
	public String toString()
	{
		return "Fat>>id:" + id;
	}
}