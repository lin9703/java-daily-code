package com.java.object.product;

/*
 * Constructor, Encapsulation, toString() 적용 
 */
public class Refrigerator extends Electronics {
	private int capacity;

	public Refrigerator(int productNo, String productName, int price, int quantity, int capacity) {
		super(productNo, productName, price, quantity);
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Refrigerator [productNo=" + productNo + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", capacity=" + capacity + "]";
	}

}
