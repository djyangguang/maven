package com.yangg.designPattern.Iterator;
/**
 * 
 * @author master-hadoop
 *迭代器模式
 *，迭代器模式就是顺序访问聚集中的对象，一般来说，
 *集合中非常常见，如果对集合类比较熟悉的话，理解本模式会十分轻松。 
 */
public class test {
	 public static void main (String[] args){
		 Collection collection = new MyCollection();
		 Iterator it =collection.iterator();
		 while(it.hashNext()){
			 System.out.println(it.next());
		 }
	 }
}
