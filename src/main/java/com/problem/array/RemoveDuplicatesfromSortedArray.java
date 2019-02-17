package com.problem.array;

import java.util.Arrays;
import java.util.BitSet;

public class RemoveDuplicatesfromSortedArray {
	public static int solution(int[] nums){
		 if(nums == null){
	           return 0;
	       }
	        if(nums.length < 2){
	            return nums.length;
	        }
	        
	        int size = 0;
	        for(int i = 0; i<nums.length; i++){
	            if(nums[i] != nums[size]){
	                nums[size+1]=nums[i];
	                size++;
	            }
	            System.out.println(Arrays.toString(nums));
	        }
	        return size+1;
    }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,1,2,2,3,3,4,4,4,5,5};
		System.out.println(solution(a));
		System.out.println(a.hashCode());
		
		int [] array = new int [] {1,2,3,22,0,3};
        BitSet bitSet  = new BitSet(6);
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++)
        {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet);
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
        System.out.println(Integer.MAX_VALUE);
	}

}
