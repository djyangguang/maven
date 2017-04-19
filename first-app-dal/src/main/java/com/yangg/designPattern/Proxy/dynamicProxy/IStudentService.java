package com.yangg.designPattern.Proxy.dynamicProxy;
// 处理相关的业务
public interface IStudentService {
	void save(Student s);
	void delete (long id);
	Student find(long id);
}
