package com.problem.application;

import java.time.LocalDate;

/*
 * 两个日期间隔天数，然后写测试用例覆盖
 * 闰年：能被4整除但不能被100整除，或能被400整除的年份即为闰年，非闰年365天，闰年共366天：四年一闰，百年不闰，四百年再闰
 * 每年的1,3,5,7，8,10月：31天
 * 每年的4,6,9,11,12月：30天
 * 闰年的2月29天，非闰年的2月28天
 */

public class DifferentDays {
	public boolean leapYear(int year){
		if((year % 4 ==0 && year % 100 !=0) || year % 400 ==0){
			return true;
		}else{
			return false;
		}
	}
	public LocalDate getBeforeOne(LocalDate day1,LocalDate day2){
		if(day1.getYear() < day2.getYear()){
			return day1;
		}else if(day1.getYear() == day2.getYear()){
			if(day1.getDayOfYear() < day2.getDayOfYear()){
				return day1;
			}else{
				return day2;
			}
		}else if(day1.getYear() > day2.getYear()){
			return day2;
		}
		return null;
	}
	public int getDaysOfMonth(int year,int month){
		switch(month){
			case 2:
				if(leapYear(year)){
					return 29;
				}else{
					return 28;
				}	
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
			case 12:
				return 30;	
			default:
				break;
					
		}
		return 30;
	}
	public int getDaysOfYear(int year){
		if(leapYear(year)){
			return 366;
		}else{
			return 365;
		}
	}
	
	public int differentDaysByManual(LocalDate day1, LocalDate day2){
		if(day1.getYear() == day2.getYear() && day1.getMonthValue() == day2.getMonthValue() && day1.getDayOfMonth() == day2.getDayOfMonth()){
			return 0;
		}
		//拿出两个日期的年份，先计算整年的天数（小的年份到大的年份-1）		
		//然后加上大的年份已经过的天数，减去小的年份已经过的天数
		int days = 0;
		
		//day1在前，day2在后
		if(getBeforeOne(day1,day2) == day1){ 
			for(int i = day1.getYear(); i < day2.getYear(); i++){
				days += getDaysOfYear(i);				
			}
			for(int j =1; j < day2.getMonthValue(); j++){
				days += getDaysOfMonth(day2.getYear(),j);
			}
			days += day2.getDayOfMonth();	
			
			for(int x =1; x < day1.getMonthValue(); x++){
				days -= getDaysOfMonth(day1.getYear(),x);
			}
			days -= day1.getDayOfMonth();	
			
		}else{ //day2在前，day1在后
			for(int m = day2.getYear(); m < day1.getYear(); m++){
				days += getDaysOfYear(m);
			}
			for(int n =1; n < day1.getMonthValue(); n++){
				days += getDaysOfMonth(day1.getYear(),n);
			}
			days += day1.getDayOfMonth();	
			
			for(int k =1; k < day2.getMonthValue(); k++){
				days -= getDaysOfMonth(day2.getYear(),k);
			}
			days -= day2.getDayOfMonth();	
		}		
		return days;
	}
	
	public static void main(String[] args){
		DifferentDays obj = new DifferentDays();
		LocalDate date1 = LocalDate.of(2017, 10, 07);
		LocalDate date2 = LocalDate.of(2015,10, 07);
		System.out.println(obj.differentDaysByManual(date1, date2));	
	}
	
}
