package com.yangg.designPattern.Interpreter;
//加法
public class Plus implements Expression {

	@Override
	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return context.getNum1()+context.getNum2();
	}

}
