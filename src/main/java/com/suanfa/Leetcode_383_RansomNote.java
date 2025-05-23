package com.suanfa;


/**
 * @description:
 * @author: jenny liang
 * @date: 2025/4/17  11:35
 * https://leetcode.cn/problems/ransom-note/description/
 */
public class Leetcode_383_RansomNote {
    public boolean canConstruct(String ransomNote,String magazine){
        //shortcut
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        //定义一个哈希映射数组
        int[] record = new int[26];

        //遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }
        //如果数组中存在负数，说明 ransomNote 字符串中存在 magezine 中没有的字符
        for(int i : record){
            if( i < 0){
                return  false;
            }
        }
        return  true;
    }
}
