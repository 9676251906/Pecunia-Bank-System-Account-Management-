package com.cg.anurag.pecunia.account.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	public static Date utildate=null;
	public static Date convertDate(String date)
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		try
		{
			utildate=sdf.parse(date);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return utildate;
	}
}
