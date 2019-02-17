package com.problem.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 检索一段话中出现频率最高的单词
 * @ 整个字符串中，先将标点符号替换为空格
 * @ 将字符串按空格（一个或多个）分割
 * @ 统计每个单词出现的次数
 * @ 排序或其他方法找出次数最多的单词
 * @遗留问题： 如果有特殊字符，或者汉字啥的该怎么去除？http://www.iteye.com/problems/89153
 */
public class MostFrequentlyWords {
	public static String findMostFrequentlyWords(String str){
		//将’号，逗号，句号均用空格替换,然后以空格来分割
		str = str.replace('\'', ' ');
		str = str.replace(',', ' ');
		str = str.replace('.', ' ');
		String[] strings = str.split("\\s+");
		
		Map<String,Integer> map = new HashMap<String,Integer>(); //存储出现的单词及个数
		List<String> list = new ArrayList<String>(); //存储每个不同的单词
		for(String string : strings){
			if(map.containsKey(string)){
				map.put(string, map.get(string) + 1); //如果map中已经包含该单词，则将其个数+1
			}else{
				map.put(string, 1); //如果该单词第一次出现,将其放入map中并将个数设置为1
				list.add(string);   //如果该单词第一次出现,将其添加到list中
			}
		}
		int maxNum = 0;
		String maxString = null;
		for(String string : list){
			if(maxNum < map.get(string)){
				maxNum = map.get(string);
				maxString = string;
			}	
		}
		System.out.println(maxString + "：" + maxNum);
		return maxString;
	}
}
