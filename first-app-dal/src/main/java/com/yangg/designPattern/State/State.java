package com.yangg.designPattern.State;
/*状态类*/
public class State {
  private String value;
  public String getValue(){
	  return value;
  }
  public void setValue(String value){
	  this.value=value;
  }
  public void method1(){
	  System.out.println("execute the first opt!执行第一选择");  
  }
  public void method2(){
	  
	  System.out.println("execute the second opt!执行第二选择");  
  }
}
