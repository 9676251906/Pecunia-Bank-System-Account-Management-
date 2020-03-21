package com.cg.anurag.pecunia.account.service;

public interface AccountService 
{
	public long openAccount(String name,long aadhar,long contactno,String gender,String date,String pan,String city,String state,String country,long zipcode,String type,double balance);
	public void deleteAccount(Long accountId);
	public void updateAccountName(long accountId,String name);
	public void updateAccountContactNumber(long accountId,long num);
	public void updateAccountAddress(long accountId,String city,String state,String country,long zipcode);
}
