package com.suanfa;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 两个数组的交集
 * @author: jenny liang
 * @date: 2025/4/1  11:55
 */
public class Leetcode_394_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        //遍历数组 1
        for (int i : nums1) {
            set1.add(i);
        }

        //遍历数组 2 的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
