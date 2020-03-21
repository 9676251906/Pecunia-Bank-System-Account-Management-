package com.cg.anurag.pecunia.account.dto;
public class CurrentAccount extends Account
{
	static double overDraftLimit=10000;
	public CurrentAccount(){}
	public CurrentAccount(long accountId, long customerId, String accountBranchId,char accountStatus, double accountBalance) 
	{
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountBranchId = accountBranchId;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}
}