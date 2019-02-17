package com.problem.application.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//http://www.2cto.com/kf/201505/403634.html
public class DateTest {
	//Date的本质是1970/1/1开始的毫秒数，long型，所有日期运算都可以用这个date.getTime取得的long值来做。
	public static int DataBetween(String fromd1,String tod2){
		int btdate = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long date1 = df.parse(fromd1).getTime();
			long date2 =df.parse(tod2).getTime();
			btdate = (int)((date2-date1)/(1000 * 60 * 60 * 24));
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return btdate;
		
	}
	public static int DateBetween2(String d1,String d2){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		int days = 0;
		try{
			Date date1 = df.parse(d1);
			Date date2 = df.parse(d2);
			Calendar can1 = Calendar.getInstance();
			Calendar can2 = Calendar.getInstance();
			can1.setTime(date1);
			can2.setTime(date2);
			//拿出两个日期的年份
			//先计算最小年份 到 最大年份-1，整年的天数
			int year1 = can1.get(Calendar.YEAR);
			int year2 = can2.get(Calendar.YEAR);
			Calendar can = null;
			can = (can1.before(can2))?can1:can2;
			for(int i=0;i<Math.abs(year2-year1);i++){
				days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
				can.add(Calendar.YEAR,1);
			}
			// 加上大的年份已过的天数，再减去小的年份已过的天数
			if(can1.before(can2)){
				days += can2.get(Calendar.DAY_OF_YEAR);
				days -= can1.get(Calendar.DAY_OF_YEAR);
			} else{
				days += can1.get(Calendar.DAY_OF_YEAR);
				days -= can2.get(Calendar.DAY_OF_YEAR);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return days;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date1 = "2008-09-01";
		String date2 = "2016-10-10";
		int btdate = DataBetween(date1,date2);
		System.out.println(btdate);
		
		int btdate2 = DataBetween(date1,date2);
		System.out.println(btdate2);
	}

}
