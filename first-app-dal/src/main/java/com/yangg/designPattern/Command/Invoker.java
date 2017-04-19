package com.yangg.designPattern.Command;
/**
 * 调度者 司令员
 * @author master-hadoop
 *
 */
public class Invoker {
	private Command command;
	public Invoker(Command command){
		this.command=command;
	}
	public void action(){
		
		command.exe();
	}
}
