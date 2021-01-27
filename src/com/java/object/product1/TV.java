package com.java.object.product1;

public class TV extends Product {
	private int inch;
	private int displayType;

	public TV() {
		super();
	}

	public TV(int productNo, String productName, int price, int quantity, int inch, int displayType) {
		super(productNo, productName, price, quantity);
		this.inch = inch;
		this.displayType = displayType;
	}

	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "TV [productNo=" + getProductNo() + ", productName=" + getProductName()
				+ ", price=" + getPrice() + ", quantity=" + getQuantity()
				+ ", inch=" + inch + ", displayType=" + displayType + "]";
	}
	

}
