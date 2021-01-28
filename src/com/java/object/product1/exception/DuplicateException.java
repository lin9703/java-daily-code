package com.java.object.product1.exception;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("이미 존재하는 상품입니다.");
	}
}
