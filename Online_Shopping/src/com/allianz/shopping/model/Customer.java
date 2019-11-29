package com.allianz.shopping.model;

public class Customer {
	private int id;
	private String username,address,password,email;
	public Customer(int id, String username, String password, String address, String email) {
		super();
		this.id = id;
		this.username = username;
		this.address = address;
		this.password = password;
		this.email = email;
	}
	public Customer() {
		super();
		
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", address=" + address + ", password=" + password
				+ ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		

}
