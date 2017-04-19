package com.yangg.designPattern.Composite;
/**
 * 
 * @author master-hadoop
 *组合模式
 *有时又叫部分-整体模式，在处理类似树形结构的问题时比较方便
 */
public class Test {
	public static void main (String [] args){
		Tree tree = new Tree("a");
		TreeNode nodeB= new TreeNode("B");
		TreeNode nodeC= new TreeNode("C");
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		nodeB.getParent();
	}
}
