package com.problem.string;

public class DeleteGivenString {
	public static String deleteGivenString(String str,String givenStr){
		String outStr = "";
		while(str.indexOf(givenStr) != -1){
			int givenStrIndex = str.indexOf(givenStr);
			outStr =outStr + str.substring(0, givenStrIndex);
			str = str.substring(givenStrIndex + givenStr.length()); 
		}
		outStr  = outStr + str;
		return outStr;
	}
}
