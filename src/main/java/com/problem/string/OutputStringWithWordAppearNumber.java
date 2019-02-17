package com.problem.string;

import java.util.HashMap;

/*
 * 输入字符串“hello world hello hi”，输出hello2 world1 hi1
 */
public class OutputStringWithWordAppearNumber {
	/*
	 * 创建一个hashMap, key = 单词，value = 单词出现次数
	 * @第一遍：遍历整个字符串，获取每个单词出现次数的hashMap
	 * @第二遍：遍历整个字符串，根据单词名称，从hashMap中读取该单词出现次数，并且从hashMap中删除该单词
	 * 			这样下次该单词再次出现，hashMap中已经不存在，不需要再打印。
	 */
	public static String outputStringWithWordAppearNumber(String str){
		String[] array = str.split("\\s+");//以空格为分割，将单词读入字符串数组中
		HashMap <String, Integer> hashMap = new HashMap<String,Integer>();
		//遍历获取每个单词的个数
		for(int i = 0; i < array.length; i++){
			if(hashMap.containsKey(array[i])){
				hashMap.put(array[i], hashMap.get(array[i]) + 1);
			}else{
				hashMap.put(array[i], 1);
			}
		}	
		
		//第二次遍历字符串
		String outStr = "";
		for(int j = 0; j < array.length; j++){
			if(hashMap.containsKey(array[j])){
				outStr = outStr + " " + array[j] + hashMap.get(array[j]);
				hashMap.remove(array[j]);
			}
		}
		return outStr.trim();
	}
}
