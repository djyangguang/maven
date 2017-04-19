package com.yangg.designPattern.Interpreter;

public class Context {
	private int mum1;
	private int mum2;
	public Context(int mum1,int mum2){
		this.mum1=mum1;
		this.mum2=mum2;
	}
	public int getNum1(){
		return mum1;
	}
	public void setNum1(int num1){
		this.mum1=mum1;
	}
	public int getNum2(){
		return mum2;
	}
	public void setNum2(int num2){
		this.mum2=mum2;
	}
}
