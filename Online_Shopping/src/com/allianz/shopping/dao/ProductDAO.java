package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Product;

public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int id);
	public List<Product> getAllProducts();
	public List<Product> getAllProductsByName(String namePattern);
	public List<Product> getAllProductsByPrice(float min,float max);

	public Product getProductById(int id);
}
