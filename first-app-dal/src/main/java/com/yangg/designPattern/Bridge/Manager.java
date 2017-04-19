package com.yangg.designPattern.Bridge;
//抽象的管理类
public abstract class Manager {
	private Driver driver;
	public void getConnection(){
		driver.getConnection();
	}
	public void setDriver(Driver driver){
		this.driver=driver;
	}
}
