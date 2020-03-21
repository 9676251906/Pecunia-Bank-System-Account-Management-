package com.cg.anurag.pecunia.account.dto;
public class Account 
{
	long accountId;
	long customerId;
	String accountBranchId;
	char accountStatus;
	double accountBalance;
	public Account() {	}
	public Account(long accountId, long customerId, String accountBranchId,char accountStatus, double accountBalance) 
	{
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountBranchId = accountBranchId;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getAccountBranchId() {
		return accountBranchId;
	}
	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}
	public char getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(char accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}	
}