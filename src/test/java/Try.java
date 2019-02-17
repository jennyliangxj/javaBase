import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-01-26
 */

public class Try {

    /**
     * 问题: try {}里有一个return语句，那么紧跟在这个try后的finally{}里的code会不会被执行，什么时候被执行，在return前还是后?
     * 答案: 会执行，执行完finally再return
     */
    public static int test() {
        int divider = 10;
        int result = 100;
        try {
            while (divider > -1) {
                divider--;
                result = result + 100 / divider;
            }
            return result;
        } catch (Exception e) {
//            e.printStackTrace();//打出抛出异常的具体信息??
            System.out.println("循环抛出异常了！！！");
            return result = 999;
        } finally {
            System.out.println("这是finally!!");
            System.out.println("我是Result！！我的值是：" + result);
        }
    }

    public static void main(String[] args){
        test();
    }
}
