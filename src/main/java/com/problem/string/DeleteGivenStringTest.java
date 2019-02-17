package com.problem.string;

public class DeleteGivenStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "000AB000BC0A000D000";
		String outStr = DeleteGivenString.deleteGivenString(str, "000");
		System.out.println(outStr);
	}
}
