package com.java.object.product1;

public class Refrigerator extends Product {

	public Refrigerator() {
		super();
	}

	public Refrigerator(int productNo, String productName, int price, int quantity) {
		super(productNo, productName, price, quantity);
	}

	@Override
	public String toString() {
		return "Refrigerator [productNo=" + getProductNo() + ", productName=" + getProductName() + ", price="
				+ getPrice() + ", quantity=" + getQuantity() + "]";
	}

}
