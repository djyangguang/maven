package com.yangg.designPattern.Visitor;
//访问者的一个具体实现
public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject sub) {
		// TODO Auto-generated method stub
			System.out.println("visit the subject：访问的主题："+sub.getSubject());
	}

}
