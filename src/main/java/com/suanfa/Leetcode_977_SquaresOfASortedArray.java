package com.suanfa;
import java.util.Arrays;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/3/28  09:45
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class Leetcode_977_SquaresOfASortedArray {
    public int[] sortedSquares1(int[] nums){
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                //正数的相对位置是不变的，需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right++;
            }
        }
        return result;
    }
}
