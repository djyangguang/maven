package com.yangg.designPattern.Iterator;

public interface  Iterator {
	public Object previous(); //前移 上个元素
	public Object next();//hou移下一个元素
	public boolean hashNext();
	public Object first();

}
