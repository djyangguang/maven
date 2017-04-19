package com.yangg.SuanFa.sort;
//当然，二分法插入排序也是稳定的。
//2017年4月19日21:43:52
//二分插入排序的比较次数与待排序记录的初始状态无关，仅依赖于记录的个数。当n较大时，比直接插入排序的最大比较次数少得多。但大于直接插入排序的最小比较次数。算法的移动次数与直接插入排序算法的相同，最坏的情况为n2/2，最好的情况为n，平均移动次数为O(n2)。
public class 二分法插入排序 {
	public static void main(String[] args){
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("排序前");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		sort(a);
		System.out.println("排序后");
		for (int i = 0; i < a.length; i++) {
		System.out.println(a[i]);	
		}
		
	}
	private static void sort(int[] a){
		for (int i = 0; i < a.length; i++) {
			int temp =a[i];
			int left =0;
			int right =i-1;
			int mid =0;
			while(left <= right){
				mid =(left+right)/2;
				if(temp<a[mid]){
					right=mid-1;
					
				}
				else {
					left =mid+1;
				}
			}
			
			
			for (int j = i-1; j >=left; j--) {
				a[j+1]=a[j];
			}
			if(left !=i){
				a[left]=temp;
			}
			
		}
	}
}
