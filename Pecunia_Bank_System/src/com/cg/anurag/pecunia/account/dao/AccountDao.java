package com.cg.anurag.pecunia.account.dao;

import com.cg.anurag.pecunia.account.dto.Account;
import com.cg.anurag.pecunia.account.dto.Address;
import com.cg.anurag.pecunia.account.dto.Customer;

public interface AccountDao 
{
	public int addAccount(Account account,Customer c,Address add);
	public int updateCustomerName(long acc,String name);
	public int updateCustomerContact(long acc,long number);
	public int updateCustomerAddress(long acc,Address add);
	public int deleteAccount(long accountId);
	public long[] getDetails();
}
