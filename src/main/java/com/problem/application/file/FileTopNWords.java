package com.problem.application.file;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 文件中出现频率topN的单词
 * @author: liangxiujie
 * @create: 2019-03-22
 */

public class FileTopNWords {

    public void getTopNWords(String fileName, int N){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            HashMap<String,Integer> map = new HashMap<>();
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String[] list = line.split("\\s+");
                for(int i = 0; i < list.length; i++) {
                    if (map.get(list[i]) == null) {
                        map.put(list[i], 1);
                    } else {
                        map.put(list[i], map.get(list[i]) + 1);
                    }
                }
            }

            System.out.println(map.size());

            TreeMap<Integer,String> treeMap = new TreeMap<>();
            Iterator iterator = map.entrySet().iterator();

            while (iterator.hasNext()){

                Map.Entry entry = (Map.Entry)iterator.next();
                treeMap.put((Integer)entry.getValue(),(String)entry.getKey());

            }


            Iterator iterator_treemap = treeMap.entrySet().iterator();
            iterator_treemap.











        }catch (FileNotFoundException e1){

        }catch (IOException e2){

        }
    }

    @Test
    public void test(){
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/problem/application/file/test.txt";
        getTopNWords(fileName,10);
    }

}
