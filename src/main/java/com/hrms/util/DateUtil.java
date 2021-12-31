package com.hrms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 关于日期的工具
public class DateUtil {

	private static SimpleDateFormat dateFormat = null;
	static {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	public static String getDate(Date date) {
		if(date == null)return null;
		String stringDate = dateFormat.format(date);
		return stringDate;
	}

	// 得到当前的年月 格式 yyyy-MM-01
	public static String getNowYearAndMonth() {
		String yearAndMonth = dateFormat.format(new Date());
		String[] split = yearAndMonth.split("-");
		return split[0] + "-" + split[1] + "-01";
	}
	// 得到date的年月 格式 yyyy-MM-01
		public static String getNowYearAndMonth(Date date) {
			String yearAndMonth = dateFormat.format(date);
			String[] split = yearAndMonth.split("-");
			return split[0] + "-" + split[1] + "-01";
		}

	public static String getYear(Date date) {
		String yearAndMonth = dateFormat.format(date);
		String[] split = yearAndMonth.split("-");
		return split[0];
	}

	public static String getMonth(Date date) {
		String yearAndMonth = dateFormat.format(date);
		String[] split = yearAndMonth.split("-");
		return split[1];
	}

	public static String getDay(Date date) {
		String yearAndMonth = dateFormat.format(date);
		String[] split = yearAndMonth.split("-");
		return split[2];
	}
	public static Date parse(String date)  {
		Date parse = null;
		try {
			parse = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parse;
	}
	public static  boolean nowIsBetweenBAndC(Date b,Date c) {
		Date now = new Date();
		if(b.getTime()-now.getTime()>=0 &&c.getTime()-now.getTime()>0) {
			return true;
		}
		return false;
	}
}
