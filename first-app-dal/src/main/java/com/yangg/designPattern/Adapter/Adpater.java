package com.yangg.designPattern.Adapter;
//类Source和接口Targetable因为不兼容，导致不能在一起工作
//适配器Adapter则可以在不改变源代码的基础上解决这个问题
//这样Targetable接口的实现类Adapter的对象即使Targetable类型,也能访问到Source中的方法
public class Adpater extends Source implements Tatgetable {

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method");
	}

}
