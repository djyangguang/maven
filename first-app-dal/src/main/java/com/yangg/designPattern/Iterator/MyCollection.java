package com.yangg.designPattern.Iterator;


//假设这个集合内部是由数组实现
public class MyCollection implements Collection {
	private String string[] = {"A","B","C","D","","E"};
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return string[i];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return string.length;
	}

}
