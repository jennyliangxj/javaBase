package com.problem.application.stockMovements;

/*
 * http://blog.sina.com.cn/s/blog_9054a03601013d5f.html
 * indexOf方法返回一个整数值，指出String对象内子字符串的开始位置，如果没有找到子字符串，返回-1。
 */
public class StockMovementsTest {
	public static int StockMovements(String SourceStr,String findStr){
		int count = 0;
		int index = 0;
		int upNum = 0;
		int downNum = 0;
		if(SourceStr.indexOf(findStr) == -1){
			return -1;
		} 
		while((index = SourceStr.indexOf(findStr,index))!=-1){
			count++;
			if(SourceStr.charAt(index+findStr.length())== '0'){
				downNum++;
			}else{
				upNum++;
			}
			System.out.println(count + ": index:" + index );
			index++;
		}
		System.out.println("upNum:"+upNum + ", downNum:" + downNum );
		if(upNum < downNum){
			return 0;
		}else if(upNum > downNum){
			return 1;
		}else if(upNum == downNum){
			return 2;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String SourceStr = "01010101";
		String findStr ="1010";
		int sotckUpDown =StockMovements(SourceStr,findStr);
		System.out.println(sotckUpDown);

	}

}
