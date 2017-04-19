package com.yangg.designPattern.Proxy.dynamicProxy;

public class StudentServiceImpl implements IStudentService {

	@Override
	public void save(Student s) {
		// TODO Auto-generated method stub
		System.out.println("save");
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		System.out.println("delete");
	}

	@Override
	public Student find(long id) {
		// TODO Auto-generated method stub
		System.out.println("find");
		return null;
	}

}
