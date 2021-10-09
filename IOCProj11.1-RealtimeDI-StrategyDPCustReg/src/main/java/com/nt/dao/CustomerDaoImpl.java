package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public class CustomerDaoImpl implements ICustomerDao
{
	
	// HAS-A PROPERTY -> DataSource
	private DataSource ds;
	
	
	// Query
	private final static String INSERT_CUST_QUERY = "INSERT INTO CUST_REG_TB VALUES (default,?,?,?,?,?)";
	
	
	
	
	
	// Since this is a mandatory injection we used the constructor injection
	public CustomerDaoImpl(DataSource ds) {
		System.out.println("CustomerDaoImpl :: 1 param constructor");
		this.ds = ds;
	}

	

	


	public int insertCustomer(CustomerBO bo) throws Exception {
		
		// Insert data into table
		int result = 0;
		// Create a connection object from the datasource entry point to a pool
		// Prepared statement
		try( Connection con = ds.getConnection();
			 PreparedStatement	ps = con.prepareStatement(INSERT_CUST_QUERY, Statement.RETURN_GENERATED_KEYS);
		   ){
			
			// Bing the placeholder
			ps.setString(1,bo.getCust_name());
			ps.setInt(2,bo.getNo_items());
			ps.setFloat(3,bo.getTotal_price());
			ps.setFloat(4, bo.getAvg_price());
			ps.setString(5, bo.getCust_status());
			// execute and update
			result = ps.executeUpdate();
			
			
			
		}catch(SQLException se) 
		{
			se.printStackTrace();
			throw se;
		}
		
		
		return result;
	}
	
	

}
