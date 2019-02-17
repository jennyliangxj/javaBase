package com.problem.sort;

import com.problem.util.*;

public class BubbleSortTest {
	public static void main(String[] args){
		
		BubbleSort bs = new BubbleSort();
		
		int[] arr1 = {9,3,4,6,1,7,10,8};
		int[] bsReturn = bs.bubbleSort(arr1);
		ArrayUtils.printArray(bsReturn);
		
		int[] arr2 = {9,3,4,6,1,7,10,8};
		int[] bdReturnPlus = bs.bubbleSortPlus(arr2);
		ArrayUtils.printArray(bdReturnPlus);
	}
}
