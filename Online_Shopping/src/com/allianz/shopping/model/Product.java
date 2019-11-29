package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {

	private int id;
	private String code;
	private String description;
	private float price;
	private Date mfDate;
	
	private List<Category> categoryList=new ArrayList<Category>();
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Product() {
		super();
	}
	public Product(int id, String code, String description, float price,Date mfDate) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.price = price;
		this.mfDate=mfDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getMfDate() {
		return mfDate;
	}
	public void setMfDate(Date mfDate) {
		this.mfDate = mfDate;
	}
	
	
}
