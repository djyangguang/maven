package com.yangg.dao.proxy;

public class TestInterFaceImpl implements TestInterface {

	@Override
	public void test() {
		test1();
		// TODO Auto-generated method stub
		System.out.println("++++test");

	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		System.out.println("++====++test2");
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		System.out.println("++++test3");
	}

}
