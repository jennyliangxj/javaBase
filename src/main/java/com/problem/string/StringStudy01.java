package com.problem.string;

public class StringStudy01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = new String("abcd");
		String str2 = new String("abcd");
		System.out.println(str2 == str);
		System.out.println(str.charAt(2));
		System.out.println(str2.equals(str));
		
		String str3 = "def";
		String str4 = "def";
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		System.out.println(str3.indexOf('y'));
		System.out.println(str3.substring(0));
		System.out.println(str3.substring(1));
		System.out.println(str3.replace('e', '*'));
		
		String str6 = "abcde,rrtt,cccee";
		String[] strArray = str6.split(",");
		for(int i=0; i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		String str7 = " aa  bb  ";
		System.out.println(str7.length() + "||" + str7.trim().length());
	}

}
