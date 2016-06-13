package service;

import java.sql.Connection;

import domain.CustomerArrayList;
import domain.CustomerException;
import persistence.CustomerRepository;

public class CustomerService 
{
	private Connection con;
	private CustomerRepository customerRep;
	
	public CustomerService(Connection con)
	{
		this.con = con;
		this.customerRep = new CustomerRepository();
	}
	public  void getCustomers(CustomerArrayList cslist) throws CustomerException
	{
		cslist.clear();
		cslist.addAll(customerRep.selectAll(con));
	}
}
