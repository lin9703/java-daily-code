package com.java.object.product1;

public class TV extends Product {

	public TV() {
		super();
	}

	public TV(int productNo, String productName, int price, int quantity) {
		super(productNo, productName, price, quantity);
	}
	

	@Override
	public String toString() {
		return "TV [productNo=" + getProductNo() + ", productName=" + getProductName()
				+ ", price=" + getPrice() + ", quantity=" + getQuantity() + "]";
	}
	

}
