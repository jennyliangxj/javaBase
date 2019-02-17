/**
 * 
 */
package com.problem.sort;

import com.problem.util.ArrayUtils;

/**
 * @author xiliang
 * @ 冒泡排序:对相邻的元素进行两两比较，顺序相反则进行交换，若从小到大排，则每趟会将最大的元素浮到末端
 * @ 时间复杂度 O(n^n)
 */
public class BubbleSort {
	public int[] bubbleSort(int[] arr){
		//判断数组情况	
		if(arr == null || arr.length <= 1){
			return arr;
		}
		int sortNum = 0;
		for(int i = 0; i < arr.length-1; i++){  //外层循环控制排序趟数
			for(int j = 0; j < arr.length-1-i; j++){ //相邻元素两两比较
				if(arr[j+1] < arr[j]){
					ArrayUtils.swap(arr, j+1,j);
				}
				ArrayUtils.printArray(arr);
				sortNum++;
			}
		}
		System.out.println("bubbleSort times:" + sortNum);
		return arr;
	}
/*
 * @冒泡排序优化：原思想没有考虑过数组是否已经有序，只是不停的判断大小决定是否交换
 * @加标识,如果第二个for循环整个下来没有交换数据，说明已经有序
 */
	public int[] bubbleSortPlus(int[] arr) {
		if (arr == null || arr.length == 1) {
			return arr;
		}
		int sortNum = 0;
		boolean flag = true;
		for(int i = 0; i < arr.length -1; i++){
			flag = true;
			for (int j = 0; j < arr.length - 1 -i; j++) {
				if (arr[j + 1] < arr[j]) {
					ArrayUtils.swap(arr, j + 1, j);
					flag = false;
				}
				ArrayUtils.printArray(arr);
				sortNum++;
			}
			if(flag == true){ //标识没有变，说明待排序列已经有序
				break;
			}
		}
		System.out.println("bubbleSort times:" + sortNum);
		return arr;
	}	
}
