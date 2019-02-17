/**
 * @description:
 * @author: liangxiujie
 * @create: 2019-02-13
 */

//https://www.cnblogs.com/mudao/p/5867107.html
//Java产生死锁的一个简单例子
//思路是创建两个字符串a和b，再创建两个线程A和B，让每个线程都用synchronized锁住字符串（A先锁a，再去锁b；B先锁b，再锁a），
// 如果A锁住a，B锁住b，A就没办法锁住b，B也没办法锁住a，这时就陷入了死锁
//可以看到，Lock1获取obj1，Lock2获取obj2，但是它们都没有办法再获取另外一个obj，因为它们都在等待对方先释放锁，这时就是死锁。

    //如果我们只运行Lock1呢？修改一下main函数，把线程b注释掉。
    //由于没有其它线程和Lock1争夺obj1和obj2，Lock1可以不断地循环获取并释放它们，这时没有死锁。

public class DeadLock {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}

class Lock1 implements Runnable {
    public void run() {
        try {
            System.out.println("Lock1 running");
            while (true) {
                synchronized (DeadLock.obj1) {
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                    synchronized (DeadLock.obj2) {
                        System.out.println("Lock1 lock obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable {
    public void run() {
        try {
            System.out.println("Lock2 running");
            while (true) {
                synchronized (DeadLock.obj2) {
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obj1) {
                        System.out.println("Lock2 lock obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

