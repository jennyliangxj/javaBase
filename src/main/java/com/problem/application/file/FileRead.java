package com.problem.application.file;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.testng.annotations.Test;

import java.io.*;

/**
 * @description: 读文件
 * @author: liangxiujie
 * @create: 2019-03-21
 */

/**
 * 在Java编程过程中，如果打开了外部资源（文件、数据库连接、网络连接等），我们必须在这些外部资源使用完毕后，手动关闭它们。
 * 因为外部资源不由JVM管理，无法享用JVM的垃圾回收机制，如果我们不在编程时确保在正确的时机关闭外部资源，就会导致外部资源泄露，
 * 紧接着就会出现文件被异常占用，数据库连接过多导致连接池溢出等诸多很严重的问题。
 */

    public class FileRead {

    /**
     * 传统的资源关闭方式
     * 为了确保外部资源一定要被关闭，通常关闭代码被写入finally代码块中，当然我们还必须注意到关闭资源时可能抛出的异常，
     */
    public void readFileByLines(String fileName){
        File file;
        BufferedReader br = null;
        try {
            file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
            String line;
            int num = 0;
            while((line = br.readLine()) != null){
                if(line.indexOf('#') != 0){
                    System.out.println(line);
                    num++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 在JDK7以前，Java没有自动关闭外部资源的语法特性，直到JDK7中新增了try-with-resource语法，才实现了这一功能
     * 将外部资源的句柄对象的创建放在try关键字后面的括号中，当这个try-catch代码块执行完毕后，Java会确保外部资源的close方法被调用
     * 当一个外部资源的句柄对象实现了AutoCloseable接口，JDK7中便可以利用try-with-resource语法更优雅的关闭资源，消除板式代码。
     */
    public void readFileByLine2(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int num = 0;
            while ((line = br.readLine()) != null){
                if (!line.startsWith("#")){
                    System.out.println(line);
                    num++;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/problem/application/file/test.txt";
        readFileByLines(fileName);

        //使用第二个方法
        readFileByLine2(fileName);
    }
}
