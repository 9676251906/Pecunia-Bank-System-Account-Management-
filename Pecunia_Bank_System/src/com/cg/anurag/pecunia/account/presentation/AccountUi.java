package com.cg.anurag.pecunia.account.presentation;

import java.util.Scanner;

import com.cg.anurag.pecunia.account.service.AccountServiceImpl;

public class AccountUi {
	AccountServiceImpl ac=new AccountServiceImpl();
	public void openAccount()
	{
		long l =0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = sc.nextLine();
		System.out.println("Enter your aaadhar number:");
		long aadnum = sc.nextLong();
		System.out.println("Enter your contact number:");
		long cont = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your gender:");
		String dum = sc.nextLine();
		System.out.println("Enter date of birth:");
		String date = sc.nextLine();
		System.out.println("Enter pan number");
		String pan = sc.nextLine();
		System.out.println("Enter city:");
		String city = sc.nextLine();
		System.out.println("Enter state");
		String state = sc.nextLine();
		System.out.println("Enter country:");
		String country = sc.nextLine();
		System.out.println("Enter zipcode");
		long zipcode = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the type of account:");
		String type = sc.nextLine();
		System.out.println("Enter the balance:");
		double balance = sc.nextDouble();
		l=ac.openAccount(name,aadnum,cont,dum,date,pan,city,state,country,zipcode,type,balance);
		if(l!=0)
			System.out.println("Opened Account and account number is"+l);
		else
			System.out.println("please try again");
	}
	public void deleteAccount()
	{
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter account number:");
		Long accno = sc.nextLong();
		ac.deleteAccount(accno);
		System.out.println("Deleted account successfully");
	}
	public void updateAccountName()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		long l = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter new Name:");
		String name = sc.nextLine();
		ac.updateAccountName(l, name);
		System.out.println("Account Updated");
	}
	public void updateAccountContactNumber()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		long l = sc.nextLong();
		System.out.println("Enter new Contact Number");
		long num = sc.nextLong();
		ac.updateAccountContactNumber(l, num);
		System.out.println("Account Updated");
	}
	public void updateAccountAddress()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number:");
		long l = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter new address:");
		System.out.println("Enter city:");
		String city = sc.nextLine();
		System.out.println("Enter state");
		String state = sc.nextLine();
		System.out.println("Enter country:");
		String country = sc.nextLine();
		System.out.println("Enter zipcode");
		long zipcode = sc.nextLong();
		ac.updateAccountAddress(l, city, state, country, zipcode);
		System.out.println("Account Updated");
	}
	

}
