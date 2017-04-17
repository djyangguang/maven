package com.yangg.designPattern.Builder;

//建造者模式
/*工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，
用来创建复合对象，所谓复合对象就是指某个类具有不同的属性。建造者模式主要用于“分步骤构建一个复杂的对象”，
在这其中“分步骤”是一个稳定的算法，而复杂对象的各个部分则经常变化。因此， 建造者模式主要用来解决“对象部分”的需求变化
 这样可以对对象构造的过程进行更加精细的控制*/
public class Test {
	public static void main(String[] args){
		Computer  lenoveComputer =null;
		 ComputerBuilder lenoveComputerBuilder = new LenoveComputerBuilder();    
		    Director director = new Director(lenoveComputerBuilder);
		    director.construct();
		    lenoveComputer = lenoveComputerBuilder.getComputer();
		    System.out.println(lenoveComputer);
		
		
	}
}
/*从这点看出，建造者模式将很多功能集成到一个类里，这个类可以创造出比较复杂的东西。所以与工程模式的区别就是：
工厂模式关注的是创建单个产品，而建造者模式则关注创建适合对象的多个部分。因此，是选择工厂模式还是建造者模式，依实际情况而定。 
例如一个Person类是由头、身体、脚三个对象组成，那么我们在建造者模式中就要先分别创造出这三个部分然后再把他们组装成一个Person对象*/