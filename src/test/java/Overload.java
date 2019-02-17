/**
 * @description: java基础-重载
 * @author: liangxiujie
 * @create: 2019-01-26
 */

public class Overload {

    //对比可知，重载，在参数类型不同的情况下，返回值类型可改变
    public String getValue(String str){
        return "aaa";
    }

    public int getValue(int str){
        return 111;
    }
}
