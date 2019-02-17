package com.problem.application.file;

import java.io.*;
import java.util.*;

public class FileTest01 {
//	public HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
	public TreeMap<String,Integer> hashMap = new TreeMap<String,Integer>();
	
	/*
	 * http://blog.csdn.net/u010180815/article/details/52208924
	 * http://www.cnblogs.com/linlf03/archive/2013/01/17/2865251.html
	 * http://www.cnblogs.com/regretless/p/5836573.html
	 * Java中过滤出字母、数字和中文的正则表达式:
	 * a.过滤出字母的正则表达式: [^(a-zA-Z)]
	 * b.过滤出 数字 的正则表达式: [^(0-9)]
	 * c. 过滤出 中文 的正则表达式 : [^(\\u4e00-\\u9fa5)]
	 * d. 过滤出字母、数字和中文的正则表达式: [^(a-zA-Z0-9\\u4e00-\\u9fa5)]
	 * 
	 */
	
	public void FileWordSort(String filePath){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			List<String> list = new ArrayList<String>();
			File logFile = new File("filesSort.log");
		
			if(logFile.exists()){
				logFile.delete();
			} else {
				logFile.createNewFile();
			}
			FileOutputStream logFileOut = new FileOutputStream(logFile,true);
			int lineNum = 0;
			int wordNum = 0;
			//按行读取文件信息，过滤出仅含有英文字母的字符串放入list
			String readline = null;
			while((readline = br.readLine())!=null){
				lineNum++;
				String[] readlineArr = readline.split("[^a-zA-Z]");//过滤出只含有英文字母的
				//	System.out.println(lineNum + ":" + wordNum);
				logFileOut.write((lineNum + "readLine source:" + readline +"\n").toString().getBytes("utf-8"));
				System.out.println(lineNum + ",read one line：" + readline);
				for(String word : readlineArr){
					if(word.length()!=0){
						wordNum++;
						list.add(word);
						logFileOut.write((lineNum + "-" + wordNum + ":" + word +"\n").toString().getBytes("utf-8"));
					}				
				}
			}
			System.out.println("line:" + lineNum + ";words:" + wordNum);
			System.out.println("int list size:" + list.size());		
			br.close();
			logFileOut.close();
			//单词的词频统计
			//遍历list列表，存入hashMap中
			for(String word:list){
				if(hashMap.get(word)!=null){
					hashMap.put(word, hashMap.get(word).intValue()+1);
				}else{
					hashMap.put(word,1);
				}				
			}				
//			sortMapByNum(hashMap);
			printSortResult(hashMap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("read file exception");
		}	
	}
	//http://blog.csdn.net/xifeijian/article/details/46522531
	//TreeMap ?
	public void sortMapByNum(HashMap<String,Integer> hashMap){
		
		
	}
	public void printSortResult(TreeMap<String,Integer> hashMap){
		Iterator iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String word = (String)iterator.next();
			System.out.println(word + ": "+ hashMap.get(word));
		}
		
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FileWordSort("D:/log/polycom/cma/log/fne-service.log");
		new FileTest01().FileWordSort("D:/log/polycom/cma/log/fne-service-all.log");
	}

}
