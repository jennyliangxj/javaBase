/**
 * 
 */
package com.problem.sort;

/**
 * @author xiliang
 * 快速排序：
 * @该方法的基本思想是：
 *	1．先从数列中取出一个数作为基准数。
 *	2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 *	3．再对左右区间重复第二步，直到各区间只有一个数。
 * 平均执行时间O(NlgN),最差O(n2)  存储空间 O(lgN)
 * @最坏时间复杂度：每次选择的关键字是待排序记录的最大（小）值时 O(n^2）
 * @最好时间复杂度：每次区间划分，基准关键字的左右两边长度相等或相差为1，即：关键字在中间：O(NlogN)
 * @平均时间复杂度：O(NlogN),所有平均时间复杂度为O(NlogN)的算法中，快速排序平均性能最好
 * @空间复杂度：O(NlogN) 最坏需要进行N-1次递归O(N)
 */
//快排，从小到大
public class QuickSort {
	public static int[] quickSort(int[] array, int start, int end){
		if(array == null || array.length == 1){
			return array;
		}
		if(start<end)  
        {  
            int key=array[start];//初始化保存基元  
            int i=start;//初始化i,j  
            for(int j=start+1;j<=end;j++){  
                if(array[j]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环  
                {  
                    int temp=array[j];  
                    array[j]=array[i+1];  
                    array[i+1]=temp;  
                    i++;  
                }   
            }  
            array[start]=array[i];//交换i处元素和基元  
            array[i]=key;  
            quickSort(array, start, i-1);//递归调用  
            quickSort(array, i+1, end);    
        }  
		return array;
	}
}
