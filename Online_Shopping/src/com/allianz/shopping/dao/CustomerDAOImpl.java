package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Customer;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DButility;
import com.allianz.shopping.utility.DateUtility;

public class CustomerDAOImpl implements CustomerDAO{



	@Override
	public boolean addCustomer(Customer customer) {
		Connection conn = null;
		int no=0;
		//Customer cust=new Customer();
		try
		{
			conn=DButility.getConnection();
			String sql="insert into cutomer(id,username,password,address,email) values(?,?,?,?,?)";
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setInt(1, customer.getId());
			psmt.setString(2, customer.getUsername());
			psmt.setString(3, customer.getPassword());
			psmt.setString(4, customer.getAddress());
			psmt.setString(5, customer.getEmail());

			no=psmt.executeUpdate();
		
		}catch(SQLException e)
		{
		
			e.printStackTrace();
		}
		if(no!=0)
		{
			return true;
		}
		else {
		return false;}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		Connection conn = DButility.getConnection();
	 List<Customer> customerList=new ArrayList<Customer>();
	 try {
		 String sql="SELECT * FROM customer";
		Statement psmt=conn.createStatement();
		ResultSet rs=psmt.executeQuery(sql);
		while(rs.next())
		{
			Customer cust=new Customer();
			cust.setId(rs.getInt("id"));
			cust.setUsername(rs.getString("username"));
			cust.setPassword(rs.getString("password"));
			cust.setAddress(rs.getString("address"));
			cust.setEmail(rs.getString("email"));
	
			customerList.add(cust);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return customerList;
	}

	@Override
	public boolean CustomerLogin(String username, String password) {
		 Connection conn = DButility.getConnection();
		    int index=0;
		    
		    try {
		      String sql="SELECT * FROM cutomer";
		     Statement psmt=conn.createStatement();
		     ResultSet rs=psmt.executeQuery(sql);
		     while(rs.next())
		     {
		      String user=rs.getString("username");
		      String pass=rs.getString("password");
		      
		      if(user.equals(username) && pass.equals(password)) {
		       index=1;
		       break;
		      }
		     }
		    }catch (Exception e) {
		    e.printStackTrace();
		    }
		    
		    if(index==1) {
		     return true;
		    }
		    else
		    
		    return false;
	}



}
