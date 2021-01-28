package com.java.object.product1.exception;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
		super("상품이 존재하지 않습니다.");
	}
}
