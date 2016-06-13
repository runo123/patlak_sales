package test;

import java.sql.Connection;
import java.sql.SQLException;

import Connection.OracleConnection;
import domain.CustomerException;

public class A_TestConnection {

	public static void main(String[] args) throws SQLException
	{
		try
		{
			OracleConnection oc = new OracleConnection();
			oc.open();
			Connection con = oc.getCon();
			System.out.println(con.getMetaData().getDatabaseMajorVersion());
			oc.close();
		} 
		catch (CustomerException e)
		{
			System.out.println(e.getMessage());
		}
			
		

	}

}
