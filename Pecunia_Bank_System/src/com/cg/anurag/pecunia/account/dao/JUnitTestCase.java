package com.cg.anurag.pecunia.account.dao;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.cg.anurag.pecunia.account.dto.Account;
import com.cg.anurag.pecunia.account.dto.Address;
import com.cg.anurag.pecunia.account.dto.Customer;
import com.cg.anurag.pecunia.account.util.ConvertDate;

public class JUnitTestCase {

	@Test
	public void testPositiveAddAccount() 
	{
		AccountDaoImpl dao=new AccountDaoImpl();
		assertEquals(true,dao.addAccount(new Account(1,12,"ii",'A',1000),new Customer(12,"Pravalika",111,123456789,"BXYDF1234H",830995785,"F",ConvertDate.convertDate("22-11-1998")),new Address(103,"Bang","Karnataka","ind",500678)));
	}
	@Test
	public void testNegativeAddAccount() 
	{
		AccountDaoImpl dao=new AccountDaoImpl();
		assertNotEquals(false,dao.addAccount(new Account(1,12,"ii",'A',1000),new Customer(12,"Pravalika",111,123456789,"BXYDF1234H",830995785,"F",ConvertDate.convertDate("22-11-1998")),new Address(103,"Bang","Karnataka","ind",500678)));
	}
	@Test
	public void testPositiveDeleteAccount()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.deleteAccount(1);
		assertEquals(rows,1);
	}
	@Test
	public void testNegativeDeleteAccount()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.deleteAccount(1);
		assertNotEquals(rows,1);
	}
	@Test
	public void testPositiveUpdateCustomerName()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.updateCustomerName(1,"Sony");
		assertEquals(true,rows);
	}
	@Test
	public void testNegativeUpdateCustomerName()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.updateCustomerName(1,"Sony");
		assertNotEquals(true,rows);
	}
	@Test
	public void testPositiveUpdateCustomerContact()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.updateCustomerContact(1,967625190);
		assertEquals(true,rows);
	}
	@Test
	public void testNegativeUpdateCustomerContact()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.updateCustomerContact(1,967625190);
		assertNotEquals(true,rows);
	}
	@Test
	public void testPositiveUpdateCustomerAddress()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.updateCustomerAddress(1,new Address(102,"hyd","ts","ind",500061));
		assertEquals(true,rows);
	}
	@Test
	public void testNegativeUpdateCustomerAddress()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		int rows=dao.updateCustomerAddress(1,new Address(102,"hyd","ts","ind",500061));
		assertNotEquals(true,rows);
	}
	@Before
	public void testBefore()
	{
		AccountDaoImpl dao = new AccountDaoImpl();
		Account acc = new Account();
		Customer c = new Customer();
		Address add = new Address();
	}
	@After
	public void testAfter()
	{
		AccountDaoImpl dao = null;
		Account acc = null;
		Customer c = null;
		Address add = null;
	}
}
