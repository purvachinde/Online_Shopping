package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Customer;
import com.allianz.shopping.model.Product;

public interface CustomerDAO {
	public boolean CustomerLogin(String username, String password);
	public boolean addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	

}
