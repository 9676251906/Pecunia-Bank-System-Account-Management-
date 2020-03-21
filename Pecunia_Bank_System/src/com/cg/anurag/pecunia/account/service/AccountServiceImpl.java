package com.cg.anurag.pecunia.account.service;

import com.cg.anurag.pecunia.account.dao.AccountDao;
import com.cg.anurag.pecunia.account.dao.AccountDaoImpl;
import com.cg.anurag.pecunia.account.dto.Account;
import com.cg.anurag.pecunia.account.dto.Address;
import com.cg.anurag.pecunia.account.dto.CurrentAccount;
import com.cg.anurag.pecunia.account.dto.Customer;
import com.cg.anurag.pecunia.account.dto.SavingsAccount;

public class AccountServiceImpl implements AccountService 
{
	static long accId =9000;
	static long custId=0;
	static long addId=0;
	AccountDao acc = new AccountDaoImpl();
	Account current= new CurrentAccount();
	Account savings = new SavingsAccount();
	Customer c = new Customer();
	Address add = new Address();
	public long openAccount(String name,long aadhar,long contactno,String gender,String date,String pan,String city,String state,String country,long zipcode,String type,double balance)
	{
		
		long a[]=acc.getDetails();
		accId=a[0]+1;
		custId=a[1]+1;
		addId=a[2]+1;
		if(type.equalsIgnoreCase("s"))
		{
			savings.setAccountId(accId);
			savings.setCustomerId(custId);
			savings.setAccountBranchId("Hyd");
			savings.setAccountStatus('A');
			savings.setAccountBalance(balance);
			c.setCustomerId(custId);
			c.setaddId(addId);
			c.setCustomerName(name);
			c.setCustomerId(custId);
			c.setCustomerAadhar(aadhar);
			c.setCustomerContact(contactno);
			c.setGender(gender);
			c.setCustomerdob(date);
			c.setCustomerPan(pan);
			add.setAddId(addId);
			add.setCity(city);
			add.setState(state);
			add.setCountry(country);
			add.setZipCode(zipcode);
			acc.addAccount(savings, c, add);
		}
		else
		{
			current.setAccountBranchId("Hyd");
			current.setAccountId(accId);
			current.setCustomerId(custId);
			current.setAccountStatus('A');
			current.setAccountBalance(balance);
			c.setaddId(addId);
			c.setCustomerName(name);
			c.setCustomerId(custId);
			c.setCustomerAadhar(aadhar);
			c.setCustomerContact(contactno);
			c.setGender(gender);
			c.setCustomerdob(date);
			c.setCustomerPan(pan);
			add.setAddId(addId);
			add.setCity(city);
			add.setState(state);
			add.setCountry(country);
			add.setZipCode(zipcode);
			acc.addAccount(current, c, add);
		}
		return accId;
	}
	public void deleteAccount(Long accountId)
	{
		acc.deleteAccount(accountId);
	}
	public void updateAccountName(long accountId,String name)
	{
		acc.updateCustomerName(accountId, name);
	}
	public void updateAccountContactNumber(long accountId,long num)
	{
		acc.updateCustomerContact(accountId, num);
	}
	public void updateAccountAddress(long accountId,String city,String state,String country,long zipcode)
	{
		Address add = new Address();
		add.setCity(city);
		add.setState(state);
		add.setCountry(country);
		add.setZipCode(zipcode);
		acc.updateCustomerAddress(accountId,add);
	}
}
