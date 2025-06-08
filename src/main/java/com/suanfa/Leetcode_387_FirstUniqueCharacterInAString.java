package com.suanfa;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * @author: jenny liang
 * @date: 2025/6/3  12:21
 * https://leetcode.cn/problems/first-unique-character-in-a-string/
 *
 * 
 */
public class Leetcode_387_FirstUniqueCharacterInAString {

    public int firstUniqChar(String str) {

        Map<Character,Integer> frequencyMap = new HashMap<Character,Integer>();
        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
         //   frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0) + 1);
            if (frequencyMap.containsKey(ch)){
                frequencyMap.put(ch,frequencyMap.get(ch) + 1);
            }else{
                frequencyMap.put(ch,1);
            }
        }

        for(int i = 0; i <  str.length();i++){
            if(frequencyMap.get(str.charAt(i)) == 1){
                return  i;
            }
        }
        return  -1;
    }

}
