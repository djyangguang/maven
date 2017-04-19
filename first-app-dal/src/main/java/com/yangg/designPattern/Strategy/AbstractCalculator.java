package com.yangg.designPattern.Strategy;
////抽象类,作为辅助类,可以提供一些你认为需要的方法
public abstract class AbstractCalculator {
	public int[] split(String exp,String opt){
		String array[] =exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0]= Integer.parseInt(array[0]);
		arrayInt[1] =Integer.parseInt(array[1]);
		return arrayInt;
	}
}
