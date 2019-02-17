package com.problem.array;
/*
 * 999个数，每个都是1-1000之间且均出现一次，找出唯一缺失的数
 */

import java.util.HashMap;

public class FindNumberLost {
	/*方法一：第一遍：遍历数组，所有出现数字存hashMap
	 * 		  第二遍：遍历从1到1000之间的数字，如果hashMap中不存在某数字，则返回该数字
	 */
	public static int getNumberLostByHash(int[] num){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < num.length; i++){
			if(!map.containsKey(num[i])){
				map.put(num[i], 1);
			}
		}
		for(int j = 1; j <=1000; j++){
			if(!map.containsKey(j)){
				return j;
			}
		}
		return 0;
	}
	/*
	 * 方法二：将数组中999个数字相加得Sum1，与1-1000的和Sum,相比较，差即为缺少的数字
	 */
	public static int getNumberLostBySum(int[] num){
		int sum1 = 0;
		int sum = 0;
		for(int i = 0; i <999; i++){
			sum1 += num[i];
		}
		for(int j = 1; j <=1000; j++){
			sum += j;
		}
		return sum - sum1;
	}
	public static void main(String[] args){
		int[] num = {1,2,3,4,5,6,7,8,10};
		System.out.println(getNumberLostBySum(num));
	}
	
	
	
}
