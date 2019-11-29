package com.allianz.shopping.model;

public class Category {

	int categoryid;
	String categorycode;
	String categorydesc;
	
	
	public Category() {
		super();
	}
	public Category(int categoryid, String categorycode, String categorydesc) {
		super();
		this.categoryid = categoryid;
		this.categorycode = categorycode;
		this.categorydesc = categorydesc;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	public String getCategorydesc() {
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}
	
	
	
	
}
