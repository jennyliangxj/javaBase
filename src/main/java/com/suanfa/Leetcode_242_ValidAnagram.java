package com.suanfa;


/**
 * @description: 有效的数组异位词
 * @author: jenny liang
 * @date: 2025/4/1  10:12
 */
public class Leetcode_242_ValidAnagram {

    public boolean isAnagram(String s, String t){
        //初始化一个的数组
        int[] record = new int[26];
        //遍历第一个数组 s
        for(int i = 0; i < s.length(); i++){
            record[s.charAt(i) - 'a']++;
        }

        // 遍历第二个数组 t
        for(int i = 0; i < t.length();i++){
            record[t.charAt(i) - 'a']--;
        }

        for(int count : record){
            //record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            if(count != 0){
                return  false;
            }
        }
        return  true;  // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}
