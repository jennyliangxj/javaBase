package com.problem.string;
/*
 * 回文的定义：正读倒读都一样
 */
public class ValidPalindrome {
	//判断一个字符串是不是回文串比如：abcd1221dcba，英文的话区分大小写字母
	public boolean isPalindrome(String str){
		if(str == null || str.length() <= 1){
			return true;
		}
		int length = str.length();
		for(int i = 0; i < length /2; i++){
			if(str.charAt(i) != str.charAt(length-i-1)){
				return false;
			}
		}
		return true;
	}
	//判断一个字符串是不是回文串，英文忽略大小写，比如a = A
	//ASCII码: 0-9：48-57；a-z:97-122; A-Z:65-90
	public boolean isPalindromeIgnoreCases(String str){
		if(str == null || str.trim().length() <= 1){
			return true;
		}
		int head = 0;
		int tail = str.length() -1;
		while(head < tail){
			if(Character.toLowerCase(str.charAt(head)) != Character.toLowerCase(str.charAt(tail))){
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}
	//判断一个字符串是不是回文串，英文忽略大小写，比如a = A，忽略非数字和字母字符
	public boolean isPalindromeIgnoreCasesAndOther(String str){
		if(str == null || str.trim().length() <= 1){
			return true;
		}
		str = str.toLowerCase();
		int head = 0;
		int tail = str.length() -1;
		while(head <= tail){
			if(!isLetterOrDigit(str.charAt(head))){
				head++;
			}else if(!isLetterOrDigit(str.charAt(tail))){
				tail--;
			}else{
				if(str.charAt(head) != str.charAt(tail)){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isLetterOrDigit(char ch){
		if(ch > 'z' || ch < 'a' && ch > '9' || ch < '0' && ch > 'Z' || ch < 'A'){
			return false;
		}
		return true;
	}
	
}
