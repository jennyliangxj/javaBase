package com.suanfa;
/**
 * @author: jenny liang
 * @date: 2025/3/27  16:34
 * 题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * leetcode:https://leetcode.cn/problems/binary-search/
 */
public class BinarySearch {
    // (版本一）左闭右闭区间，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）。
    public int search1(int[] nums, int target) {
        //避免当 target 小于 nums[0], 大于nums[nums.length -1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return-1;
    }

    //（版本二）左闭右开区间
    public int search2(int[] nums,int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return -1;
    }
}
