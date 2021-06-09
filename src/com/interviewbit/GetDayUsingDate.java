package com.interviewbit;
import java.time.LocalDate;
import java.util.Scanner;

public class GetDayUsingDate {

	public static String getDay(String day, String month, String year) {
		LocalDate date = LocalDate.parse(year+"-"+month+"-"+day);
		return date.getDayOfWeek().toString();
	}

	public static void main(String[] args) {

		/**** don't alter the code below *************************************/

		Scanner in = new Scanner(System.in);
		String month = in.next();
		String day = in.next();
		String year = in.next();
		in.close();
		System.out.println(getDay(day, month, year));

		/****************************************************/

	}
}
/**
08
05
2015
Output Wednesday
*/