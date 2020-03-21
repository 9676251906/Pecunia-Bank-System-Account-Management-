package com.cg.anurag.pecunia.account.dto;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.anurag.pecunia.account.util.ConvertDate;


public class Customer 
{ 
	long customerId;
	String customerName;
	long addId;
	long customerAadhar;
	String customerPan;
	long customerContact;
	String gender;
	Date customerdob;
	public Customer() 
	{
		super();
	}
	public Customer(long customerId, String customerName, long addId, long customerAadhar,
			String customerPan, long customerContact, String gender, Date customerdob) 
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.addId = addId;
		this.customerAadhar = customerAadhar;
		this.customerPan = customerPan;
		this.customerContact = customerContact;
		this.gender = gender;
		this.customerdob = customerdob;
	}
	public long getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(long customerId) 
	{
		this.customerId = customerId;
	}
	public String getCustomerName() 
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = validateCustomerName(customerName);
	}
	public String validateCustomerName(String customerName)
	{
		String regx = "[a-zA-Z]+\\.?";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(customerName);
	    if(matcher.matches())
	    {
	    	return customerName;
	    }
	    else
	    {
	    	System.out.println("Only characters and spaces are allowed");
	    	return null;
	    }
	}
	public long getaddId() 
	{
		return addId;
	}
	public void setaddId(long addId)
	{
		this.addId = addId;
	}
	public long getCustomerAadhar() 
	{
		return customerAadhar;
	}
	public void setCustomerAadhar(long customerAadhar) 
	{
		this.customerAadhar = customerAadhar;
	}
	public String getCustomerPan() 
	{
		return customerPan;
	}
	public void setCustomerPan(String customerPan) 
	{
		this.customerPan = validateCustomerPan(customerPan);
	}
	
	public String validateCustomerPan(String customerPan) 
	{
		if(customerPan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
			return customerPan;
		else
		{
			System.out.println("Invalid PAN");
			return null;
		}
	}
	public long getCustomerContact() 
	{
		return customerContact;
	}
	public void setCustomerContact(long customerContact) 
	{
		this.customerContact = customerContact;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public void setCustomerdob(String customerdob)
	{
		this.customerdob = ConvertDate.convertDate(customerdob);
	}
	public Date getCustomerdob() 
	{
		return customerdob;
	}
}

