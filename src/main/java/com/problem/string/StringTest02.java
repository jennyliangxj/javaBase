package com.problem.string;
/*
 * 寻找一个字符串中最长的重复子串
 * http://www.2cto.com/kf/201309/244112.html
 * 最长重复字符串，极端情况就比如abcabc,或者abcdabc,最长重复字符串abc，即最大为字符串长度的一半
 */

public class StringTest02 {
	public static String getMaxRepSubString(String str){
		String reg,left;
		for(int len = str.length()/2; len>0; len--){
			for(int i = 0;i<str.length()/len;i++){
				reg=str.substring(0,len+1);
				left=str.substring(len+1);
				if(left.indexOf(reg)!=-1){
					return reg;
				}
			}	
		}
		return null;
	}
	
/*
 * 获取一个字符串中重复子串，按重复次数排序，若次数相同，按首字母排序
 * 
 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
