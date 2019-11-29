package com.allianz.shopping.dao;

import static com.allianz.shopping.utility.DateUtility.convertStringToDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DButility;
import com.allianz.shopping.utility.DateUtility;

public class CategoryDAOImpl implements CategoryDAO{

	
	private static List<Category> categoryList=new ArrayList<Category>();
	static
	{
		 categoryList.add(new Category(101,"colgate","colgate tube1"));
		 categoryList.add(new Category(102,"colgate2","colgate tube2"));
		 categoryList.add(new Category(103,"colgate3","colgate tube3"));
	}
	
	@Override
	public boolean addCategory(Category category) {
		/*Connection conn = null;
		try
		{
			conn=DButility.getConnection();
			String sql="insert into category(category_id,category_code,category_desc)values(?,?,?)";
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setInt(1, category.getCategoryid());
			psmt.setString(2, category.getCategorycode());
			psmt.setString(3, category.getCategorydesc());
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
*/
		categoryList.add(category);
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		
		Connection conn = DButility.getConnection();
		 String sql="UPDATE category SET category_code=?,category_desc=? WHERE category_id=?";
		 try {
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setString(1, category.getCategorycode());
			psmt.setString(2, category.getCategorydesc());
			psmt.setInt(3,category.getCategoryid());
			
			return psmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCategory(int categoryid) {
		
		Connection conn = DButility.getConnection();
		 String sql="Delete from category where category_id=?";
		 try {
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setInt(1, categoryid);
			
			return psmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Category> getAllCategory() {
		
		/*Connection conn = DButility.getConnection();
		 List<Category> categorytList=new ArrayList<Category>();
		 try {
			 String sql="SELECT * FROM category";
			Statement psmt=conn.createStatement();
			ResultSet rs=psmt.executeQuery(sql);
			while(rs.next())
			{
				Category category=new Category();
				category.setCategoryid(rs.getInt("category_id"));
				category.setCategorycode(rs.getString("category_code"));
				category.setCategorydesc(rs.getString("category_desc"));
				categorytList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
			return categoryList;
	}

	@Override
	public List<Category> getAllCategoryByCode(String categorycode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryById(int categoryid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategoryByProductId(int id) {
		Connection conn = DButility.getConnection();
		 List<Category> categorytList=new ArrayList<Category>();
		 try {
			 String sql="SELECT * FROM category where category_id in (select category_id from product_category where id=?";
			PreparedStatement psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs=psmt.executeQuery(sql);
			while(rs.next())
			{
				Category category=new Category();
				category.setCategoryid(rs.getInt("category_id"));
				category.setCategorycode(rs.getString("category_code"));
				category.setCategorydesc(rs.getString("category_desc"));
				categorytList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return categorytList;
	}

	
}
