package com.problem.string;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-02-18
 */

public class ValidIP {
    /**
     * a.字符串长度: 最短:0.0.0.0 7位，最长: 000.000.000.000 15位
     * b.尝试按.符号进行拆分    拆分结果应该是4段
     * c.查看拆分到的每一个子字符串，应该都是纯数字
     * d.对拆分结果转成整数 判断 应该是0到255之间的整数
     */
    public boolean check(String str){
        //字符串长度: 最短:0.0.0.0 7位，最长: 000.000.000.000 15位
        if(str.length() < 7 || str.length() > 15){
            return false;
        }

        // 尝试按.符号进行拆分    拆分结果应该是4段
        String[] arr = str.split("\\.");
        if(arr.length != 4){
            return false;
        }

        //查看拆分到的每一个子字符串，应该都是纯数字
        for(int i = 0; i < 4; i++){
            for(int j = 0 ; j < arr[i].length(); j++){
                char temp = arr[i].charAt(j);
                if(!(temp > '0' && temp < '9')){
                    return false;
                }
            }
        }

        //对拆分结果转成整数 判断 应该是0到255之间的整数
        for(int m = 0; m < 4; m++){
            int temp = Integer.parseInt(arr[m]);
            if (temp < 0  || temp > 255){
                return false;
            }
        }
        return true;
    }
}
