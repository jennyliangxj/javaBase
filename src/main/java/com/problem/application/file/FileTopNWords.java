package com.problem.application.file;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;

/**
 * @description: 文件中出现频率topN的单词
 * @author: liangxiujie
 * @create: 2019-03-22
 */

public class FileTopNWords {

    public List<String> getTopNWords(String fileName, int N) throws IOException {

        BufferedReader bufferedReader = null;
        try {
            //遍历文件，利用哈希表排序
            bufferedReader = new BufferedReader(new FileReader(fileName));
            HashMap<String, Integer> map = new HashMap<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] list = line.split("\\s+");
                for (int i = 0; i < list.length; i++) {
                    if (map.get(list[i]) == null) {
                        map.put(list[i], 1);
                    } else {
                        map.put(list[i], map.get(list[i]) + 1);
                    }
                }
            }

            //用 list 存储字符 key,然后自定义 Comparator 比较器对 value 进行排序
            List<String> list = new ArrayList<>(map.keySet());

            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (map.get(o1).equals(map.get(o2))) {
                        return o1.compareTo(o2);
                    } else {
                        return map.get(o2) - map.get(o1);
                    }
                }
            });
            return list.subList(0, N);

        } catch (FileNotFoundException e1) {
            e1.getStackTrace();


        } catch (IOException e2) {
            e2.getStackTrace();

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        return null;
    }

    @Test
    public void test() throws IOException {
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/problem/application/file/test.txt";
        List<String> list;
        list = getTopNWords(fileName,10);
        System.out.println(list.toString());
    }
}
