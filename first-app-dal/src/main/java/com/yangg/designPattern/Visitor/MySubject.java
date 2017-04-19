package com.yangg.designPattern.Visitor;
//被访问者的一个具体实现
public class MySubject implements Subject{

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return "love";
	}

}
