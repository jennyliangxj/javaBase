/**
 * 
 */
package com.problem.string;

import java.util.ArrayList;

/**
 * @author xiliang
 * 找出str中str1和str2之间的字符串，并写出测试用例
 * @ String substring(int beginIndex,int endIndex) 
 * @ beginIndex:开始处的索引（包括），endIndex结束处的索引（不包括）
 */
public class StringBetweenTwoGivenStrings {
	public static String getStringBetweenTwoGivenStrings(String str,String str1,String str2){
		int a = str.indexOf(str1);
		int b = str.indexOf(str2);
		String btStr = null;
		if(a <= b){
			 btStr = str.substring(a + str1.length(), b);
		}else{
			 btStr = str.substring(b + str2.length(), a);
		}
		return btStr;
	}
	/*
	 * 定义一个循环，判断字符串str1和str2在str中第一次出现的位置，取出中间部分
	 * 将中间部分放入list,最后取剩余部分的字符串更新str
	 */
	public static ArrayList<String> getStringBetweenTwoGivenStringsPlus(String str,String str1,String str2){
		if(str == null || str1 == null || str2 == null ||"".equals(str) || "".equals(str1) ||"".equals(str2)){
			return null;
		}
		
		ArrayList<String> btlist = new ArrayList<String>();
		String btStr;
		while(str.indexOf(str1) != -1 && str.indexOf(str2)!= -1){
			int a = str.indexOf(str1);
			int b = str.indexOf(str2);
			if(a <= b){
				btStr = str.substring(a + str1.length(), b);
				btlist.add(btStr);
				str = str.substring(b + str2.length());
			}else{
				btStr = str.substring(b + str2.length(), a);
				btlist.add(btStr);
				str = str.substring(a + str1.length());
			}
		}
		return btlist;
	}
}
