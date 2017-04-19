package com.yangg.designPattern.Memento;

public class Original {
	private String value;
	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value=value;
	}
	public Original(String value){
		this.value=value;
	}
	//创建备忘录对象来存储属性值
	public Memento createMemento(){
		return new Memento(value);
	}
	/*还原属性值*/
	public void restoreMemento(Memento memento){
		this.value=memento.getValue();
	}
}
