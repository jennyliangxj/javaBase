package com.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jenny liang
 * @date: 2025/4/1  16:01
 */
public class Leetcode_454_4sumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3,int[] nums4){
        int res = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入 map
        for(int i : nums1){
            for(int j: nums2){
                int sum = i+j;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }

        //统计剩余的两个元素的和，在 map中找是否存在相加为 0 的情况，同时记录次数
        for(int i: nums3){
            for(int j:nums4){
                int sum1= 0-i-j;
                res += map.getOrDefault(sum1,0);
            }
        }
        return res;
    }
}
