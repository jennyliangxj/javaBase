package com.problem.application.redpackage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class RedPackage {
	public void allocation(int m, int n){
		double total = m;
		int num = n;
		double min = 0.01;
		double money = 0.00;
		double random_money = 0.00;
		Random random = new Random();
		
		for(int i = 1; i<num; i++){
			double max = (total-(num-i)*min)/(num-i);
			random_money = random.nextDouble()*max + min;
			BigDecimal bd = new BigDecimal(random_money);
			money = bd.setScale(2,RoundingMode.HALF_UP).doubleValue();	
			total =(new BigDecimal(total - money)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			
			System.out.println("red package " + i + ":" + money + "; remain sum: " + total);			
		}
		System.out.println("red package " + num + ":" + total +";remain sum : 0");		
	}
	
	public void randomTest1(){
		// new Random()类，新建对象产生随机数，可以产生随机整数int，随机float,随机double,随机long
		//http://www.cnblogs.com/elleniou/p/3334886.html
		System.out.println("---------new Random() method test:--------");
		Random ran1 = new Random();
		
		float ran1_float = ran1.nextFloat();
		double ran1_double = ran1.nextDouble();
		long ran1_long = ran1.nextLong();
		
		BigDecimal bd_float = new BigDecimal(ran1_float);
		bd_float = bd_float.setScale(2, RoundingMode.HALF_UP);
		
		BigDecimal bd_double = new BigDecimal(ran1_double);
		double ran1_double_2 = bd_double.setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		BigDecimal bd_long = new BigDecimal(ran1_long);
		bd_long = bd_long.setScale(2, RoundingMode.HALF_UP);
		
		double sum = 4.60;
		
		System.out.println("ran1_double_2: " + ran1_double_2 + "; sum - ran1_double_2:" +(sum-ran1_double_2));
		
		double random_float = Float.parseFloat(bd_float.toString());
		System.out.println("random_float: " + random_float + "; sum - random_float:" +(sum-random_float));
		
		double random_double = Double.parseDouble(bd_double.toString());
		System.out.println("random_double: " + random_double + "; sum - random_double:" +(sum-random_double));
		
		System.out.println(" float:" + ran1_float + "\n double:" + ran1_double + "\n long:" + ran1_long);	
		System.out.println("get two number from float:" + bd_float);
		System.out.println("get two number from double:" + bd_double);
		System.out.println("get two number from long:" + bd_long);
		System.out.println("---------new Math.random() method test:--------");			
	}
	
	public void randomTest2(){
		// Math.random() generate one double number from 0-1
		// Math.random()
		// 产生0-1之间的一个double随机数，可以将其乘以一定数，比如100，便获得一个0-100之间的double随机数
		double ran2 = Math.random();
		double ran2_100 = Math.random() * 100;
		System.out.println("Math.random():" + ran2 + "; Math.random() * 100:"
				+ ran2_100);			

	}
	// http://www.jb51.net/article/46010.htm
	public void decimalTest(){
		DecimalFormat df = new DecimalFormat("#.00");
		double d1 = 3.234556;
		double d2 = 0.0;
		double d3 = 2.0001;
		df.format(d1);
		df.format(d2);
		df.format(d3);
		System.out.println("d1:" + d1 + ", d2:" +d2 + ", d3:" + d3);
		System.out.println("d1:" + 	(df.format(d1))+ ", d2:" +d2 + ", d3:" + d3);
		
		//这种返回可能不是2位小数，因为double 类型的1 保存的有可能是1.0000000000004，或者0.9999999999
		System.out.println(4.23 - Double.parseDouble(df.format(d1)));
		
		//double 类型转换为int类型是舍弃全部的，所以可以先乘以100强转为int型，然后+0.0意思为将int类型转为double型
		System.out.println ((0.0 + (int)((4.23 - d1)* 100)) / 100);
		System.out.println ((0.0 + (int)(0.9999999999* 100)) / 100);
		
		
		
		
		
	}
	
}
