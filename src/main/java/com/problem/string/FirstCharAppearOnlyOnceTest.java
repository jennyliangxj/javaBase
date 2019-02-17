package com.problem.string;

public class FirstCharAppearOnlyOnceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "avnverfnverfaavvfredfvgclopmp";
		char ch01 = FirstCharAppearOnlyOnce.getFirstCharAppearOnlyOnce(str);
		char ch02 = FirstCharAppearOnlyOnce.getFirstCharAppearOnlyOncePlus(str);
		System.out.println(ch01);
		System.out.println(ch02);	
	}
}
