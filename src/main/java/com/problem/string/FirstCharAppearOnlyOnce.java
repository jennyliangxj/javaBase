package com.problem.string;
/*
 * 在一个字符串中找到第一个只出现一次的字符
 */

import java.util.HashMap;

public class FirstCharAppearOnlyOnce {
	/*
	 * @方法一：分别取第1,2,...n个字符跟所有的字符进行比较，返回第一个只出现一次的字符,两个for循环嵌套
	 * 时间复杂度:O(n^2)
	 */
	public static char getFirstCharAppearOnlyOnce(String str){
		for(int i = 0; i < str.length()-1; i++){
			boolean flag = true;  //设置标识
			for(int j = 0; j < str.length(); j++){
				if(str.charAt(j) == str.charAt(i) && i != j){ //当遇到第一个跟给定字符相同，并且小标不同的字符时，标识改变，跳出内层for循环
					flag = false;
					break;
				}
			}
			if(flag == true){  //标识未改变，说明没有跟给定字符相同的字符，该字符仅出现一次，返回
				return str.charAt(i);
			}
		}
		return 0;
	}
	/*
	 * @方法二：创建一个hashMap,key=字符，value=字符出现次数，遍历两边字符串
	 * @第一遍：遍历整个字符串，获取每个字符出现次数的hashMap
	 * @第二遍：遍历整个字符串，从hashMap中依次读取每个字符串出现次数，返回第一个出现一次的字符。
	 */
	public static char getFirstCharAppearOnlyOncePlus(String str){
		HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
	//	Map<Character,Integer> map = Collections.synchronizedMap(hashMap);
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(hashMap.containsKey(ch)){
				hashMap.put(ch, hashMap.get(ch) + 1);
			}else{
				hashMap.put(ch, 1);
			}
		}
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(hashMap.get(ch) == 1){
				return ch;
			}
		}
		return 0;
	}

}

/*  
 * 
 */
