package com.problem.sort;
import java.util.Arrays;

public class QuickSortTest {
	public static void main(String[] args){
		int arr [] = {5,9,3,10,17,25,18,12,8,6,9,10,7};
		QuickSort.quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));	
		}
}
