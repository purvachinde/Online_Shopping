package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;

public interface CategoryDAO {

	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryid);
	public List<Category> getAllCategory();
	public List<Category> getAllCategoryByCode(String categorycode);
	public List<Category> getAllCategoryByProductId(int id);
	public Category getCategoryById(int categoryid);
	

}
