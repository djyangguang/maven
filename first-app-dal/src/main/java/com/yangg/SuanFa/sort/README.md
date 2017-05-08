
排序一直以来都是让我很头疼的事，

　　排序大的分类可以分为两种：内排序和外排序。在排序过程中，全部记录存放在内存，则称为内排序，如果排序过程中需要使用外存，则称为外排序。下面讲的排序都是属于内排序。

　　内排序有可以分为以下几类：

　　(1)、插入排序：直接插入排序、二分法插入排序、希尔排序。

　　(2)、选择排序：简单选择排序、堆排序。

　　(3)、交换排序：冒泡排序、快速排序。

　　(4)、归并排序

　　(5)、基数排序





总结：

一、稳定性:

　   稳定：冒泡排序、插入排序、归并排序和基数排序

　　不稳定：选择排序、快速排序、希尔排序、堆排序

二、平均时间复杂度

　　O(n^2):直接插入排序，简单选择排序，冒泡排序。

　　在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。当数据较大时，冒泡排序算法的时间代价最高。性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。

　　O(nlogn):快速排序，归并排序，希尔排序，堆排序。

　　其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。

三、排序算法的选择

　　1.数据规模较小

  　　（1）待排序列基本序的情况下，可以选择直接插入排序；

  　　（2）对稳定性不作要求宜用简单选择排序，对稳定性有要求宜用插入或冒泡

　　2.数据规模不是很大

　　（1）完全可以用内存空间，序列杂乱无序，对稳定性没有要求，快速排序，此时要付出log（N）的额外空间。

　　（2）序列本身可能有序，对稳定性有要求，空间允许下，宜用归并排序

　　3.数据规模很大

   　　（1）对稳定性有求，则可考虑归并排序。

    　　（2）对稳定性没要求，宜用堆排序

　　4.序列初始基本有序（正序），宜用直接插入，冒泡