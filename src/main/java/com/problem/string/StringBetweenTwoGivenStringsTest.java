package com.problem.string;

import java.util.ArrayList;

public class StringBetweenTwoGivenStringsTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "woeinfioenf qoirenf ononorn wolanroi nslsnvwosindfdfreroirjtoswocrgeoijmjwngovs";
		String str1 = "wo";
		String str2 = "oi";
		String bt = StringBetweenTwoGivenStrings.getStringBetweenTwoGivenStrings(str, str1, str2);
		System.out.println(bt);
		ArrayList<String> btPlus = StringBetweenTwoGivenStrings.getStringBetweenTwoGivenStringsPlus(str, str1, str2);
		System.out.println(btPlus.toString());
	}
}
