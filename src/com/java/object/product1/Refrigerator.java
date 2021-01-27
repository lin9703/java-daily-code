package com.java.object.product1;

public class Refrigerator extends Product {
	private int capacity;

	public Refrigerator() {
		super();
	}

	public Refrigerator(int productNo, String productName, int price, int quantity, int capacity) {
		super(productNo, productName, price, quantity);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Refrigerator [productNo=" + getProductNo() + ", productName=" + getProductName()
				+ ", price=" + getPrice() + ", quantity=" + getQuantity() + ", capacity=" + capacity + "]";
	}
	
}
