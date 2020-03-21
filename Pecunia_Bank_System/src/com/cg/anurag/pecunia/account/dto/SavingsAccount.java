package com.cg.anurag.pecunia.account.dto;
public class SavingsAccount extends Account
{
	static double roi=0.04;
	static int transPerDay=4;
	static double minBalance=1000;
	public SavingsAccount(){}
	public SavingsAccount(long accountId, long customerId, String accountBranchId,char accountStatus, double accountBalance) 
	{
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountBranchId = accountBranchId;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}
}