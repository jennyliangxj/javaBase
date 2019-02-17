/**
 * 假设有n层楼梯，每次只能上一层或两层，共有多少种走法
 */
package com.problem.application.floor;

/**
 * @author xiliang
 *
 */
public class Solution {
	// 采用斐波那契数列，递归方法
	public int climStairFibonacci (int n){		
		if(n<1){
			return 0;
		}
		// if n=1,return 1;
		// if n=2, return 2;
		if(n<=2){
			return n;
		}
		int s1=1,s2=2,s=0;
		for(int i=3;i<=n;i++) {
			s=s1+s2;
			s1=s2;
			s2=s;
		}		
		return s;
	}
	/*根据数学排列组合找出爬楼梯的规律
	 * 偶数：假设总有10层楼梯:C(10,0)+C(9,1)+C(8,2)+C(7,3)+C(6,4)+C(5,5)
	 * 奇数：假设总有11层楼梯：C(11,0)+C(10,1)+C(9,2)+C(8,3)+C(7,4)+C(6,5)
	 * 得出规律：下标从N到N-N/2，上标从0到N/2，上标加下边=N
	 */
	
	public int climStairC(int n){
		if(n<1){
			return 0;
		}
		int s = 0;
		for(int i=0;i<=n/2;i++){
			s= s +C(n-i,i);
		}
		
		return s;
		
	}
	/* 组合C(X,Y)=A(X,X)/(A(Y,Y)*A(X-Y))
	 * 参数校验:x>0;y>=0
	 * C(X，0)=1
	 * C(X,X)=1
	 */
	public int C(int x, int y){
		if(x<=0 || y<0 || y>x){
			return 0;
		}
		if(y==0 || x==y){
			return 1;		
		}
		return A(x,x)/A(y,y) / A(x-y,x-y);	
	}
	/* 排列A(x,y)=x(x-1)(x-2)...(x-y+1)
	 * 参数校验x>0;y>=0
	 * A(x,0) =1
	 */	
	public int A(int x, int y){
		if(x<=0 || y<0 || (y>x)){
			return 0;
		}
		int s=1;
		for(int i = x; i>=x-y+1; i--){
			s = s* i;
		}
		return s;
	}
}
