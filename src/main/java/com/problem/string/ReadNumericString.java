package com.problem.string;
/*
 * 给一个string类型数字字符串，比如“1026”，范围0000-9999，打印繁体读法string-----"壹仟零贰什陆”
 * 
 */
public class ReadNumericString {
	public static String readNumericString(String str){
		String[] str1 = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String[] str2 = {"","拾","佰","仟"};
		String outStr = "";
		int b = Integer.parseInt(str);
		int length = 0;
		System.out.println(b);
		while(b > 0){
			int value = b % 10;
			b = b / 10;		
			if(value == 0){
				outStr = str1[value]  + outStr;					
			}else{
				outStr = str1[value]  +str2[length] + outStr;	
			}
			length++;
		}
		System.out.println(outStr);
		return outStr;
	}
}
