/**
 * 
 */
package com.problem.sort;

import java.util.Arrays;

/*
 * 选择排序：平均与最差情况 执行时间O(n2), 空间 O(1)
 * 线性逐一扫描数组元素，从中挑选出最小的元素，移到数组最前面（即与最前面元素交换）
 * 再次线性扫描数组，找到第二个小的元素，移到前面，与前面元素交换
 * 不断扫描，直到完成排序
 */
public class SelectSort {
	public static void Sort(int [] arr){
		int index = 0, temp;
		for(int i = 0; i<arr.length-1; i++){
			index = i;
			for(int j = i + 1; j<arr.length;j++){
				if(arr[j] < arr[index]){	//比较选出最小的那个元素	 			
					index = j;
				}
			}
			
			if(index !=i){  //如果找出有更小的元素，则进行交换
				temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {20,4,6,19,8,5};	
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
