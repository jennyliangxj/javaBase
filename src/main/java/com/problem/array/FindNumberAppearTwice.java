package com.problem.array;
/*
 * 1001个数字，包含每个1-1000的数，找出唯一一个出现两次的数（多种方法）
 */

import java.util.HashMap;

public class FindNumberAppearTwice {
	//方法一：遍历数组，存hashMap，如果出现过则hashMap中已经存在，返回该数值
	public static int getNumberByHash(int[] num){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < num.length; i++){
			if(map.containsKey(num[i])){
				return num[i];
			}else{
				map.put(num[i], 1);
			}
		}	
		return 0;
	}
	//方法二：将这1001个数字相加Sum1，与1-1000的和Sum相比，Sum1-Sum的差就是出现了两次的那个数字
	public static int getNumberBySum(int[] num){
		int sum = 0;
		int sum1 = 0;
		for(int i = 1; i <=1000; i++){
			sum += i;
		}
		for(int j = 0; j<=1000;j++){
			sum1 += num[j];
		}	
		return sum1 -sum;
	}
	public static void main(String[] args){
		int[] num = {1,2,3,4,5,6,7,8,9,10,9};
		System.out.println(getNumberBySum(num)); //将方法二里的1000改为10
	}
	
}
