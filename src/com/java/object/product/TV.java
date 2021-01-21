package com.java.object.product;

/*
 * Constructor, Encapsulation, toString() 적용 
 */
public class TV extends Electronics {
	private int inch;
	private int displayType;

	public TV(int productNo, String productName, int price, int quantity, int inch, int displayType) {
		super(productNo, productName, price, quantity);
		this.inch = inch;
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "TV [productNo=" + productNo + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + ", inch=" + inch + ", displayType=" + displayType + "]";
	}

}
