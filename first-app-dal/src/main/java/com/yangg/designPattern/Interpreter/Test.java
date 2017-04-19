package com.yangg.designPattern.Interpreter;
/**
 * 
 * @author master-hadoop
 *解释器模式
 *例子:解释器接口(这里的是专门解析数学运算表达式)
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // 计算9+2-8的值  
		int result = new Minus().interpret(new Context(
                new Plus().interpret(new Context(9, 2)), 8));
		//相当于:new Minus().interpret(new Context(11, 8));
	    System.out.println(result);  
	}

}

//有一个简单的语法规则，比如一个sql语句，如果我们需要根据sql语句进行其他语言的转换，就可以使用解释器模式来对语句进行解释。
//一些重复发生的问题，比如加减乘除四则运算，但是公式每次都不同，有时是a+b-c*d，有时是a*b+c-d，等等等等个，公式千变万化，
//但是都是由加减乘除四个非终结符来连接的，这时我们就可以使用解释器模式。