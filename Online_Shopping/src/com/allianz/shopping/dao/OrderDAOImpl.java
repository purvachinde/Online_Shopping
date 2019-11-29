package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DButility;
import com.allianz.shopping.utility.DateUtility;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public int addOrder(Order order) {
		Connection conn = null;
		try
		{
			conn=DButility.getConnection();
			String sql="insert into order_table(order_id,orderDate,totalPrice,status,username)values(?,?,?,?,?)";
			PreparedStatement psmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			psmt.setInt(1, order.getOrder_id());
			psmt.setDate(2, DateUtility.convertUtilToSql(order.getOrderDate()));
			psmt.setFloat(3, order.getTotalPrice());
			psmt.setString(4,	order.getStatus());
			psmt.setString(5,	order.getUsername());
			int no=psmt.executeUpdate();
			ResultSet rs=null;
			rs=psmt.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
		if(no>0)
		{
			conn.commit();
			
		}
		
		}catch(SQLException e)
		{
		
			e.printStackTrace();
		}
		return 0;
	}



}
