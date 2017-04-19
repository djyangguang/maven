package com.yangg.designPattern.Bridge;
//具体的驱动管理类
public class DriverManager extends Manager {

	public DriverManager(Driver driver){
			setDriver(driver);
	}
	public void getConnection(){
		super.getConnection();
	}
}
