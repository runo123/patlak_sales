package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import domain.CustomerException;

public class OracleConnection 
{
	private Connection con;
	
	public OracleConnection () throws CustomerException
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			open();
		}
		catch(ClassNotFoundException e)
		{
			throw new CustomerException("Could not find database driver");
		}
	}
	public void open () throws CustomerException
	{
		try 
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.2.15:1521:orcl","PATLAK","oracle");
			con.setAutoCommit(false);
		} 
		catch (SQLException e)  
		{
			
			throw new CustomerException("Could not open database connectionsdfsdfsdfsdf");
		
		}
	}
	public void close() throws CustomerException
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			
			throw new CustomerException("Could not close database connection");
		
		}
	}
	public Connection getCon() 
	{
		return con;
	}
	
	
	
}
