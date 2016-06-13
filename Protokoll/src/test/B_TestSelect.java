package test;

import Connection.OracleConnection;
import domain.CustomerArrayList;
import domain.CustomerException;
import service.CustomerService;

public class B_TestSelect 
{

	public static void main(String[] args) 
	{
		try
		{
			CustomerArrayList cslist = new CustomerArrayList();
			OracleConnection oracon = new OracleConnection();
			CustomerService customerService = new CustomerService(oracon.getCon());
			customerService.getCustomers(cslist);
			System.out.println(cslist);
			oracon.close();
			
		}
		catch(CustomerException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
