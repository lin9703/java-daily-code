package com.java.object.product;

public class ProductTest {

	public static void main(String[] args) {
		TV tv = new TV(37, "삼성 티비", 10000000, 22, 45, 1);
		System.out.println(tv);

		Refrigerator refrigerator = new Refrigerator(22, "삼성 냉장고", 10000000, 56, 100);
		System.out.println(refrigerator);
	}

}
