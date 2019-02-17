package com.problem.application.redpackage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// http://www.cnblogs.com/nayitian/p/3214178.htm
public class DoubleFormatTest {
	
	//Math.round 返回与参数最接近的长整数，四舍五入
	public static double doubleFormat1(double d){
		//round： 小数四舍五入后转为double型
		double df = (double)Math.round(d);
		//round:乘以100，小数四舍五入后转为double型，除以100，得到小数点后2位
		double df2 = (double)Math.round(d * 100) /100;
		System.out.println(df + " \n" + df2);
		return df;
	}
	
	//The BigDecimal class
	public static double doubleFormat2(double d){
		BigDecimal bd = new BigDecimal(d).setScale(2, RoundingMode.UP);
		return bd.doubleValue();	
	}
	
	public static String doubleFormat3(double d){
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		//保留两位小数，如果不需要四舍五入，可以使用RoundingMode.DOWN
		nf.setMaximumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.UP);
		return nf.format(d);
	}
	
	public static String doubleFormat4(double d){
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(d);
	}
	
	public static String doubleFormat5(double d){
		return String.format("%.2f", d);
	}
	
	
	public static void main(String[] args){
		
		double d = 12345.1789;
		doubleFormat1(d);
		System.out.println(doubleFormat2(d));
		System.out.println(doubleFormat3(d));
		System.out.println(doubleFormat4(d));
		System.out.println(doubleFormat5(d));
		
	}
}
