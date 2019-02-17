package com.problem.application;

import java.time.LocalDate;

public class DifferentDaysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentDays obj = new DifferentDays();
		LocalDate date1 = LocalDate.of(2017, 10, 07);
		LocalDate date2 = LocalDate.of(2015,10, 07);
		System.out.println(obj.differentDaysByManual(date1, date2));	

	}

}
