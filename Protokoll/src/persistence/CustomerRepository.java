package persistence;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import domain.Customer;
import domain.CustomerException;

public class CustomerRepository
{
	private final static String SQL_SELECT_ALL = 
			"SELECT CUSTOMER_ID, " +
		      " 	FIRST_NAME, "+
		      " 	CREDIT "+
		      "FROM CUSTOMER ;";
	
	
	private PreparedStatement selectAllStatement;
	
	public ArrayList<Customer> selectAll(Connection con) throws CustomerException
	{
		try
		{
			if(selectAllStatement == null)
			selectAllStatement = con.prepareStatement(SQL_SELECT_ALL);
			ResultSet resultSet = selectAllStatement.executeQuery();
			if(resultSet != null)
			{
				ArrayList<Customer> customers = new ArrayList<>(1000);
				while(resultSet.next())
				{
					int customerID = resultSet.getInt(1);
					String firstName = resultSet.getString(2);
					Double credit = resultSet.getDouble(3);
					customers.add(new Customer(customerID,firstName,credit));
					
					
				}
				return customers;
			}
			else
			{
				throw new CustomerException("Could not read Data from databae!");
			}
		
		}
		catch(SQLException e)
		{
			throw new CustomerException("Could not execute SQL statement");
		}
	}
	
}
