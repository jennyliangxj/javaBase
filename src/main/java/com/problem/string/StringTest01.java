package com.problem.string;

/*
 * 获取两个字符串中最长相同子串
 * http://blog.csdn.net/sinat_28729797/article/details/51348182
 * http://blog.csdn.net/iemdm1110/article/details/51357178
 * 1.比较两个字符串的长短，赋予两个字符串
 * 2.从短的字符串中：截取子串，一个变量从开头开始，一个变量从结尾开始，到中间相遇后停止
 * 3.截取子串后，到长的字符串进行比较
 * 4.最大子串赋予返回变量
 */
public class StringTest01 {
	public static String getMaxSubString(String str1,String str2){
		String maxStr = "";
		//str:两个字符串中长的那个
		//key:两个字符串中短的那个
		String str = (str1.length() >= str2.length())?str1:str2;
		String key = str.equals(str1)?str2:str1;
		for(int i=0;i<key.length();i++){
			for(int j=key.length();j>i;j--){
				String temp = key.substring(i, j);
				if(str.indexOf(temp)!=-1 && maxStr.length() < temp.length()){
					maxStr = temp;
				}
			}
		}	
		return maxStr;
	}
	/*
	 * 获取两个字符串中相同子串，并按首字母排序
	 */
	public static String getSubStringList(String str1,String str2){
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "asljwknjfonwnfirengfornf";
		String str2 = "slnjaonfoewonwnonwnaodnfiawdonwnf";
		String maxStr = getMaxSubString(str1,str2);
		System.out.println(maxStr);

	}

}
