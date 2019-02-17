import org.testng.annotations.Test;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-01-26
 */

/**
 * 1、不管有没有出现异常，finally块中代码都会执行；
 * 2、当try和catch中有return时，finally仍然会执行；
 * 3、finally是在return后面的表达式运算之后执行的；
 *
 * 对于含有return语句的情况，这里我们可以简单地总结如下：
 *
 * try语句在返回前，将其他所有的操作执行完，保留好要返回的值，而后转入执行finally中的语句，而后分为以下三种情况：
 *
 * 情况一：如果finally中有return语句，则会将try中的return语句“覆盖”掉，直接执行finally中的return语句，得到返回值，这样便无法得到try之前保留好的返回值。
 *
 * 情况二：如果finally中没有return语句，也没有改变要返回值，则执行完finally中的语句后，会接着执行try中的return语句，返回之前保留的值。
 *
 * 情况三：如果finally中没有return语句，但是改变了要返回的值，这里有点类似与引用传递和值传递的区别，分以下两种情况：
 *
 * 1）如果return的数据是基本数据类型或文本字符串，则在finally中对该基本数据的改变不起作用，try中的return语句依然会返回进入finally块之前保留的值。
 * 2）如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，try中的return语句返回的就是在finally中改变后的该属性的值。
 */
public class TryCatchTest {

    /**
     * https://itimetraveler.github.io/2017/09/20/%E3%80%90Java%E3%80%91try-catch-finally%E8%AF%AD%E5%8F%A5%E4%B8%ADreturn%E7%9A%84%E6%89%A7%E8%A1%8C%E9%A1%BA%E5%BA%8F%E6%80%9D%E8%80%83/
     */
    @Test
    public void testng1(){
        int a1 = test1();
        System.out.println("test1()函数返回:" + a1);

        int a2 = test2();
        System.out.println("test2()函数返回:" + a2);

        int a3 = test3();
        System.out.println("test3()函数返回:" + a3);

        int a4 = test4();
        System.out.println("test3()函数返回:" + a4);
    }

    public int test1(){
        int i = 0;
        try {
            System.out.println("Try block executing: " + ++i);
            return i;
        }catch (Exception e){
            System.out.println("Catch Error executing: " + ++i);
            return -1;
        }finally {
            System.out.println("finally executing: " + ++i);
        }
    }

    public int test2(){
        int i = 0;
        try {
            System.out.println("Try block executing: " + ++i);
            return i;
        }catch (Exception e){
            System.out.println("Catch Error executing: " + ++i);
            return -1;
        }finally {
            System.out.println("finally executing: " + ++i);
            return i;
        }
    }

    public int test3(){
        int i = 0;
        try {
            System.out.println("Try block executing: " + ++i);
            return ++i;
        }catch (Exception e){
            System.out.println("Catch Error executing: " + ++i);
            return -1;
        }finally {
            System.out.println("finally executing: " + ++i);
            return i;
        }
    }

    public int test4(){
        int i = 0;
        try {
            System.out.println("Try block executing: " + ++i);
            return ++i;
        }catch (Exception e){
            System.out.println("Catch Error executing: " + ++i);
            return -1;
        }finally {
            System.out.println("finally executing: " + ++i);
        }
    }
}
