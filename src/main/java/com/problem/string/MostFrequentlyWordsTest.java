package com.problem.string;

public class MostFrequentlyWordsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Look to the skies above @ # # #  London and you’## ### # # ll see the # usual suspects rainclouds, plane and pigeons. But by the end of the year, you might just see something else.";
		String maxString = MostFrequentlyWords.findMostFrequentlyWords(str);
		System.out.println(maxString);
	}
}
