/**
 * 
 */
package com.problem.string;

/**
 * @author xiliang
 *
 */
public class IsUnique {
	public static boolean isUniqueChars(String str){
		if(str.length() > 128){
			return false;
		}
		boolean [] char_set = new boolean[128];
		for(int i = 0;i<str.length();i++){
			int val = str.charAt(i);  //char类型强制转换为int类型，为char 字符所对应的ASCII码
			System.out.println("char:" + str.charAt(i)+ " ASCII:"+ val);
			if(char_set[val]){ //这个字符已经在字符串中出现过
				return false;
			}
			char_set[val]=true;
		}
		return true;
	}

}
