package com.suanfa;


import java.util.HashSet;
import java.util.Set;

/**
 * @description: 快乐数
 * @author: jenny liang
 * @date: 2025/4/1  15:11
 */
public class Leetcode_202_HappyNumber {

    public boolean isHappy(int n){
        Set<Integer> record = new HashSet<>();
        while (n != 1 && record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return n ==1;
    }

    private int getNextNumber(int n){
        int res = 0;
        while (n > 0){
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return  res;
    }
}
