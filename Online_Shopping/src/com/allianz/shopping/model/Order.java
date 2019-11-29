package com.allianz.shopping.model;

import java.util.Date;

public class Order {
	private int order_id;
	private Date orderDate;
	private float totalPrice;
String status,username;

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", status="
				+ status + ", username=" + username + "]";
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int order_id, Date orderDate, float totalPrice, String status, String username) {
		super();
		this.order_id = order_id;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.username = username;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
