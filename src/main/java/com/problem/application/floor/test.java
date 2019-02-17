package com.problem.application.floor;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int s11 = solution.climStairFibonacci(10);
		System.out.println("climStairFibonacci 10 floors, ways:" + s11);
		int s12 = solution.climStairFibonacci(11);
		System.out.println("climStairFibonacci 11 floors, ways:" + s12);
		
		int s21 = solution.climStairC(10);
		System.out.println("climStairC 10 floors, ways:" + s21);
		int s22 = solution.climStairC(11);
		System.out.println("climStairC 11 floors, ways:" + s22);
		
		int a1 = solution.A(10,10);
		System.out.println("A 10 10:" + a1);
		int a2 = solution.A(10,0);
		System.out.println("A 10 0:" + a2);
		int a3 = solution.A(10,1);
		System.out.println("A 10 1:" + a3);
		
		int c1 = solution.C(10,10);
		System.out.println("C 10 10:" + c1);
		int c2 = solution.C(10,0);
		System.out.println("C 10 0:" + c2);
		int c3 = solution.C(10,2);
		System.out.println("C 10 2:" + c3);		
	}
}
