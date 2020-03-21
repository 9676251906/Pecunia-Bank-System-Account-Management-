package com.cg.anurag.pecunia.account.util;

public class CustomerQueries 
{
	public static String addCust = "insert into customer values(?,?,?,?,?,?,?,?)";
	public static String deletecust = "delete from customer where customer_id=?";
	public static String select = "select * from customer where customer_id=?";
	public static String details = "select * from customer";
}
