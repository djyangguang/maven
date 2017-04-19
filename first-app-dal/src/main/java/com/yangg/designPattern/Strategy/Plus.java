package com.yangg.designPattern.Strategy;
//+
public class Plus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculator(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "[+]");//重点
		return arrayInt[0]+arrayInt[1];
	}

}
