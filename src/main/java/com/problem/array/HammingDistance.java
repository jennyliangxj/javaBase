package com.problem.array;

public class HammingDistance {
	
	public static int solution1(int x,int y){
		return Integer.bitCount(x^y);
	}
	
	/*
	 	<< : 左移运算符，num << 1,相当于num乘以2
		>> : 右移运算符，num >> 1,相当于num除以2
		
		比如1001，右移一位，除以2，如果有余数的话，那么最后一位为1
	 */
	public static int solution2(int x,int y){
		 int d = 0;
	        int bitxor = x ^ y;
	        
	        while (bitxor > 0){
	            if (bitxor % 2 == 1){
	                d++;
	            }
	            bitxor = bitxor >> 1;
	         //   System.out.println(bitxor);
	        }
	        
	    return d;
	}
	public static int solution3(int x,int y){
		int xor = x ^ y, count = 0;
	    for (int i=0;i<32;i++) count += (xor >> i) & 1;
	    return count;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2, y=11;
		System.out.println(solution1(x,y));
		System.out.println(solution2(x,y));
		System.out.println(solution3(x,y));
		System.out.println(10>>1);
	}

}
