package com.suanfa;


/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/28  15:06
 */
public class Leetcode_209_MinimumSizeSubarraySum {

    //方法一：暴力法

    //方法二：滑动窗口
    public int  minSubArrayLen(int target, int[] nums){
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= target){
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return  result == Integer.MAX_VALUE ? 0 : result;
    }
}
