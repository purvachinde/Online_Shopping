package com.allianz.shopping.model;

public class AddToCart {
	private int id, product_id, quantity, order_id;
	private float total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddToCart(int id, int product_id, int quantity, int order_id, float total) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.order_id = order_id;
		this.total = total;
	}

	@Override
	public String toString() {
		return "AddToCart [id=" + id + ", product_id=" + product_id + ", quantity=" + quantity + ", order_id="
				+ order_id + ", total=" + total + "]";
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
