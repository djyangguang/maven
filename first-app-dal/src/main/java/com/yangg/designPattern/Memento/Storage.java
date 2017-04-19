package com.yangg.designPattern.Memento;
/*存储备忘录的类，持有memento类的实例*/
public class Storage {
	private Memento memento;
	public Storage(Memento memento){
		this.memento=memento;
	}
	public Memento getMemento(){
		return memento;
		
	}
	public void setMemento(Memento memento){
		this.memento=memento;
	}
}
