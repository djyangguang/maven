package com.yangg.designPattern.Visitor;
//被访问者接口
public interface Subject {
	public void accept(Visitor visitor);
	public String getSubject();
}
