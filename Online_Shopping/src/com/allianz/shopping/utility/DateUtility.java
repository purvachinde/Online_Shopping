package com.allianz.shopping.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	public static Date convertStringToDate(String date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		
		Date datelocal;
		try {
			datelocal = sdf.parse(date);
			return datelocal;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	public static String convertDateToString(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		 String datelocal = sdf.format(date);
		 return datelocal;
	}
	public static java.sql.Date convertUtilToSql(java.util.Date date)
	{
		java.sql.Date datesql=new java.sql.Date(date.getTime());
		return datesql;
		
	}
	
}
