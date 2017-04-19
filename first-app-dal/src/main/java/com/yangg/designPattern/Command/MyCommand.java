package com.yangg.designPattern.Command;
/**
 * 
 * @author master-hadoop
 *具体的实现命令
 */
public class MyCommand implements Command {
	private Receiver receiver;
	public MyCommand(Receiver receiver){
		this.receiver=receiver;
	}
	public void exe(){
		
		receiver.action();
	}
}
