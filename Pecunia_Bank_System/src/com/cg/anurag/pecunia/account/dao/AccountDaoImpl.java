package com.cg.anurag.pecunia.account.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.anurag.pecunia.account.dto.Account;
import com.cg.anurag.pecunia.account.dto.Address;
import com.cg.anurag.pecunia.account.dto.Customer;
import com.cg.anurag.pecunia.account.dto.SavingsAccount;
import com.cg.anurag.pecunia.account.util.AccountDBQueries;
import com.cg.anurag.pecunia.account.util.AddressQueries;

import com.cg.anurag.pecunia.account.util.CustomerQueries;

public class AccountDaoImpl implements AccountDao
{
	private Connection connection=null;
	private PreparedStatement pst;

	private ResultSet result;
	public void openConnection() 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@Localhost:1521:xe";
			connection = DriverManager.getConnection(url,"scott","tiger");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public long[] getDetails()
	{
		long a=0,b=0,c=0;
		openConnection();
		try
		{
			pst = connection.prepareStatement(AddressQueries.sel);
			result = pst.executeQuery();
			while(result.next())
			{
				c=result.getLong(1);				
			}
			result.close();
			pst.close();
			pst = connection.prepareStatement(CustomerQueries.details);
			result = pst.executeQuery();
			while(result.next())
			{
				b=result.getLong(1);	
			}
			result.close();
			pst.close();
			pst = connection.prepareStatement(AccountDBQueries.details);
			result = pst.executeQuery();
			while(result.next())
			{
				a=result.getLong(1);	
			}
			result.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		long[] d = new long[3];
		d[0] = a;
		d[1]=b;
		d[2]=c;
		return d;
	}
	@Override
	public int addAccount(Account account,Customer c,Address add) 
	{
		openConnection();
		int rows=0;
		try
		{
			pst = connection.prepareStatement(AddressQueries.addquery);
			pst.setLong(1, add.getAddId());
			pst.setString(2, add.getCity());
			pst.setString(3, add.getState());
			pst.setString(4, add.getCountry());
			pst.setLong(5,add.getZipCode());
			pst.executeUpdate();
			pst.close();
			pst = connection.prepareStatement(CustomerQueries.addCust);
			pst.setLong(1, c.getCustomerId());
			pst.setString(2, c.getCustomerName());
			pst.setLong(3, add.getAddId());
			pst.setLong(4, c.getCustomerAadhar());
			pst.setLong(5, c.getCustomerContact());
			pst.setString(6, c.getGender());
			@SuppressWarnings("deprecation")
			Date sqldate = new Date(c.getCustomerdob().getYear(),c.getCustomerdob().getMonth(),c.getCustomerdob().getDate());
			pst.setDate(7,sqldate);
			pst.setString(8, c.getCustomerPan());
			pst.executeUpdate();
			pst.close();
			pst=connection.prepareStatement(AccountDBQueries.addAccountQuery);
			pst.setLong(1,account.getAccountId());
			pst.setLong(2, c.getCustomerId());
			pst.setString(3, account.getAccountBranchId());
			pst.setString(4,String.valueOf(account.getAccountStatus()));
			pst.setDouble(5, account.getAccountBalance());
			if(account instanceof SavingsAccount)
			{
			    pst.setString(6,"s");
			    pst.setInt(7, 4); pst.setInt(8, 5);   pst.setDouble(9, 500);  pst.setDouble(10,0);
			}
			else
			{
				pst.setString(6, "c");   pst.setInt(7, 0);  pst.setInt(8, 0);  pst.setDouble(9, 0.0);
				pst.setDouble(10, 10000);
			}
			pst.executeUpdate();
			pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}

		return rows;
	}

	@Override
	public int deleteAccount(long accountId) 
	{
		openConnection();
		int rows=0;
		long l=0,a=0;
		try 
		{
			pst = connection.prepareStatement(AccountDBQueries.select);
			pst.setLong(1, accountId);
			result = pst.executeQuery();
			result.next();
			l = result.getLong(2);
			result.close();
			pst.close();
			pst = connection.prepareStatement(CustomerQueries.select);
			pst.setLong(1,l);
			result=pst.executeQuery();
			result.next();
			a = result.getLong(3);
			result.close();
			pst.close();
			pst=connection.prepareStatement(AccountDBQueries.deleteAccountQuery);
			pst.setLong(1,accountId);
			pst.executeUpdate();
			pst.close();
			pst = connection.prepareStatement(CustomerQueries.deletecust);
			pst.setLong(1,l);
			pst.executeUpdate();
			pst.close();
			pst = connection.prepareStatement(AddressQueries.delquery);
			pst.setLong(1,a);
			rows=pst.executeUpdate();
			pst.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return rows;
	}

	@Override
	public int updateCustomerName(long acc,String name) 
	{
		openConnection();
		int rows=0;
		long l=0;
		try
		{
			pst = connection.prepareStatement(AccountDBQueries.select);
			pst.setLong(1, acc);
			result = pst.executeQuery();
			result.next();
			l = result.getLong(2);
			result.close();
			pst=connection.prepareStatement(AccountDBQueries.updateCustomerNameQuery);
			pst.setLong(2,l);
			pst.setString(1,name);
			pst.executeUpdate();
			pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		 return rows;
	}

	@Override
	public int updateCustomerContact(long acc,long number) 
	{
		openConnection();
		int rows=0;
		long l=0;
		try
		{
			pst = connection.prepareStatement(AccountDBQueries.select);
			pst.setLong(1, acc);
			result = pst.executeQuery();
			result.next();
			l = result.getLong(2);
			result.close();
			pst=connection.prepareStatement(AccountDBQueries.updateCustomerContactQuery);
			pst.setLong(2,l);
			pst.setLong(1,number);
			pst.executeUpdate();
			pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return rows;
	}

	@Override
	public int updateCustomerAddress(long acc,Address add) 
	{
		openConnection();
		int rows=0;
		@SuppressWarnings("unused")
		long l=0;
		try
		{
			pst = connection.prepareStatement(AccountDBQueries.select);
			pst.setLong(1, acc);
			result = pst.executeQuery();
			result.next();
			l = result.getLong(2);
			result.close();
			pst=connection.prepareStatement(AccountDBQueries.updateCustomerAddressQuery);
			pst.setLong(5,acc);
			pst.setString(1, add.getCity());
			pst.setString(2, add.getState());
			pst.setString(3, add.getCountry());
			pst.setLong(4, add.getZipCode());
			pst.executeUpdate();
			pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return rows;
	}
}

