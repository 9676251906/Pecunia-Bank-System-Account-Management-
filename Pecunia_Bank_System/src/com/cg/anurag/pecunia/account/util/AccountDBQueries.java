package com.cg.anurag.pecunia.account.util;

public class AccountDBQueries 
{
	public static String addAccountQuery="insert into account values(?,?,?,?,?,?,?,?,?,?)";
	public static String updateCustomerNameQuery="update customer set name=? where customer_id=?";
	public static String updateCustomerContactQuery="update customer set contact_no=? where customer_id=?";
	public static String updateCustomerAddressQuery="update address set city=?,state=?,country=?,zipCode=? where account_id=?";
	public static String deleteAccountQuery="delete from account where account_id=?";
	public static String select = "select * from account where account_id=?";
	public static String details="select * from account";
}
