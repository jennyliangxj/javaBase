package com.problem.string;

/**
 * @description: 字符串中有数字和字母，如abc123045,返回123+45的和
 * @author: liangxiujie
 * @create: 2019-02-21
 */

public class StringTest03 {

    public static int solution(String str){

        //遍历字符串，将数字一一选出，组合成新的字符串
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i) >= '0') && (str.charAt(i) <= '9')){
                sb.append(str.charAt(i));
            }
        }

        //将字符串以0为分隔符，分割到数组里面
        String[] arr = sb.toString().split("0");

        //将数组里的值相加
        int sum = 0;
        for(int j = 0; j < arr.length; j++){
            System.out.println( j + ": " + arr[j]);

            sum += Integer.parseInt(arr[j]);
        }
        System.out.println(sb);
        return sum;
    }

    public static void main(String[] args){
        String str = "abc123c34efr56f0g32";
        int sum = solution(str);
        System.out.println(sum);
    }
}
