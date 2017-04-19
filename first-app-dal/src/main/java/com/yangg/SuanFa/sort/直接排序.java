package com.yangg.SuanFa.sort;
//直接排序
//每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止
public class 直接排序 {
	public static void main(String[] args) {
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("排序前");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}
		for (int i = 0; i < a.length; i++) {
			int temp=a[i];
			int j;
			for(j=i-1;j>=0;j--){
				//将大于temp的往后移动一位
				if(a[j]>temp){
					a[j+1]=a[j];
				}
				else{
					break;
				}
			}
			a[j+1]=temp;
		}
		 System.out.println("排序之后：");
		 for (int i = 0; i < a.length; i++) {
			 System.out.print(a[i]+" ");
			 
		 }
	}
}

//文件初态不同时，直接插入排序所耗费的时间有很大差异。若文件初态为正序，则每个待插入的记录只需要比较一次就能够找到合适的位置插入，
//故算法的时间复杂度为O(n)，这时最好的情况。若初态为反序，则第i个待插入记录需要比较i+1次才能找到合适位置插入，故时间复杂度为O(n2)，这时最坏的情况。
//
//直接插入排序的平均时间复杂度为O(n2)。
