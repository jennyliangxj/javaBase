package com.problem.string;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-02-19
 */

//将 'abc123' 字符串反转

public class StringReverse {
    //利用 StringBuffer 或 StringBuilder 的 reverse 成员方法:
    public String reverse(String str){
        return  new StringBuffer(str).reverse().toString();
    }

    //利用 String 的 toCharArray 方法先将字符串转化为 char 类型数组，然后将各个字符进行重新拼接:
    public String reverse2(String str){
        char[] arr = str.toCharArray();
        String reverse = "";
        for(int i = str.length() -1; i >=0; i--){
            reverse += arr[i];
        }
        return reverse;
    }

    public String reverse3(String str){
        String reverse = "";
        for(int i = 0; i < str.length(); i++){
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
