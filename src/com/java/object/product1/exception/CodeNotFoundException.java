package com.java.object.product1.exception;

public class CodeNotFoundException extends Exception {
	public CodeNotFoundException(int productNo) {
		super("상품번호 " + productNo + "이 존재하지 않습니다.");
	}
}
