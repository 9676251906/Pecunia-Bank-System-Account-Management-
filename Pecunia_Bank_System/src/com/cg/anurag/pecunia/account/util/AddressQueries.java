package com.cg.anurag.pecunia.account.util;

public class AddressQueries 
{
	public static String addquery = "insert into address values(?,?,?,?,?)";
	public static String select = "select * from address where add_id=?";
	public static String delquery = "delete from address where add_id=?";
	public static String sel = "select * from address";
}
