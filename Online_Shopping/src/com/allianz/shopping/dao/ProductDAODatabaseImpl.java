package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.utility.DButility;
import com.allianz.shopping.utility.DateUtility;
import com.allianz.shopping.model.Product;

public class ProductDAODatabaseImpl implements ProductDAO{

	@Override
		public boolean addProduct(Product product)
	{
		Connection conn = null;
		try
		{
			conn=DButility.getConnection();
			String sql="insert into product(id,code,description,price,mfDate)values(?,?,?,?,?)";
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setInt(1, product.getId());
			psmt.setString(2, product.getCode());
			psmt.setString(3, product.getDescription());
			psmt.setFloat(4, product.getPrice());
			psmt.setDate(5,DateUtility.convertUtilToSql(product.getMfDate()));
		int no=psmt.executeUpdate();
		if(no>0)
		{
			conn.commit();
			return true;
		}
		
		}catch(SQLException e)
		{
			if(conn!=null)
			{
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Connection conn = null;
		try
		{
			conn=DButility.getConnection();
			String sql="update product set code=?,description=?,price=?,mfDate=? where id=?";
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setString(1, product.getCode());
			psmt.setString(2, product.getDescription());
			psmt.setFloat(3, product.getPrice());
			psmt.setDate(4, DateUtility.convertUtilToSql(product.getMfDate()));
			psmt.setInt(5,product.getId());
		int no=psmt.executeUpdate();
		if(no>0)
		{
			conn.commit();
			return true;
		}
		
		}catch(SQLException e)
		{
			if(conn!=null)
			{
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
				Connection con;
				try {
					con=DButility.getConnection();
					String sql="delete from product where id=?";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setInt(1, id);
					int no=pst.executeUpdate();
					if(no>0) {
						return true;
					}
					
				}catch(Exception e) {
					
				}
				return false;
	}

	@Override
	public List<Product> getAllProducts() {
				Connection conn = DButility.getConnection();
	 List<Product> productList=new ArrayList<Product>();
	 try {
		 String sql="SELECT * FROM product";
		Statement psmt=conn.createStatement();
		ResultSet rs=psmt.executeQuery(sql);
		while(rs.next())
		{
			Product product=new Product();
			CategoryDAOImpl daoimpl=new CategoryDAOImpl();
			product.setId(rs.getInt("id"));
			product.setCode(rs.getString("code"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getFloat("price"));
			product.setMfDate(rs.getDate("mfDate"));
			productList.add(product);
			//product.setCategoryList(daoimpl.getAllCategoryByProductId(product.getId()));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return productList;
	}

	@Override
	public List<Product> getAllProductsByName(String namePattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProductsByPrice(float min, float max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(int id) {
		Connection con;
		Product product=new Product();
		try {
			con=DButility.getConnection();
			String sql="select * from product where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				product.setId(rs.getInt("id"));
				product.setCode(rs.getString("code"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setMfDate(rs.getDate("mfDate"));
				return product;
			}
			
		}catch(Exception e) {
			
		}
		
	
		return null;
	}

}
