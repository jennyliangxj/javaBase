/**
 * @description: static
 * @author: liangxiujie
 * @create: 2019-02-13
 */

public class Static {
    private static int num = 0;
    public Static(){
        num++;
    }
    public static void main(String[] args){
        Static s1 = new Static();
        Static s2 = new Static();
        System.out.println("s1 num:" + s1.num);  //2
        System.out.println("s2 num:" + s2.num);  //2
    }

    public static void StringTest(){
         StringBuilder stringBuilder = new StringBuilder();
         StringBuffer stringBuffer = new StringBuffer();



    }
}
