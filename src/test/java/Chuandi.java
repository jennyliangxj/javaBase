/**
 * @description: java 按值传递 引用传递
 * @author: liangxiujie
 * @create: 2019-02-20
 * https://blog.csdn.net/u013309870/article/details/75499175
 */

public class Chuandi {

    public static void main(String[] args) {

        //demo1
        String str=new String("hello");
        char []chs={'w','o','r','l','d'};
        change(str, chs);
        System.out.println(str+" "+new String(chs));    // hello World


        //demo2
        StringBuffer sb=new StringBuffer("hello");
        change(sb);
        System.out.println(sb);  // hello world

        //demo3
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        operate(a,b);
        System.out.println(a+"."+b);  //AB.B

        //demo4
        int[] arr ={10,20};
        System.out.println("arr[0] :" + arr[0]+"arr[1] : " + arr[1]);//arr[0]=10,arr[1]=20;
        swap(arr, 0, 1);
        System.out.println("arr[0] :" + arr[0]+"arr[1] : " + arr[1]);//arr[0]=20,arr[1]=10;
    }
    public static void change(StringBuffer sb)
    {
        sb.append(" world");
//      sb.deleteCharAt(0);
    }
    public static void change(String str,char[]chs)
    {
        str.replace('h', 'H');
        chs[0]='W';
    }

    static void operate(StringBuffer x,StringBuffer y)
    {
        x.append(y);
        y=x;
    }

    public static void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        System.out.println("arr[0] :" + arr[0]+"arr[1] : " +arr[1]);//arr[0]=20,arr[1]=10;
    }
}
