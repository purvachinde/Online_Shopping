package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.utility.DButility;
import com.allianz.shopping.utility.DateUtility;

public class AddToCartImpl implements AddToCartInterface{

	@Override
	public boolean addAddToCart(AddToCart addToCart) {
		Connection conn = null;
		try
		{
			conn=DButility.getConnection();
			String sql="insert into cart(id, product_id, quantity, order_id,total)values(?,?,?,?,?)";
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setInt(1, addToCart.getId());
			psmt.setInt(2, addToCart.getProduct_id());
			psmt.setInt(3, addToCart.getQuantity());
			psmt.setInt(4, addToCart.getOrder_id());
			psmt.setFloat(5, addToCart.getTotal());
			
		int no=psmt.executeUpdate();
		if(no>0)
		{
			conn.commit();
			return true;
		}
		
		}catch(SQLException e)
		{
		
			e.printStackTrace();
		}
		return false;
	}


}
