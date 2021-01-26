package com.java.object.product1;

import java.util.Arrays;

public class ProductMgr {
	private static int MAX_SIZE = 100;
	private Product[] products = new Product[MAX_SIZE];
	private int cnt;
	private static ProductMgr productMgr;

	private ProductMgr() {
	}

	public static ProductMgr getInstance() {
		if (productMgr == null) {
			productMgr = new ProductMgr();
		}
		return productMgr;
	}

	// 상품 저장
	public void add(Product p) {
		if (cnt < MAX_SIZE) {
			products[cnt++] = p;
		}
	}

	// 저장된 상품 조회
	public Product[] list() {
		return Arrays.copyOf(products, cnt);
	}

	// 상품 번호로 검색
	public Product list(int num) {
		for (int i = 0; i < cnt; i++) {
			if (products[i].getProductNo() == num) {
				return products[i];
			}
		}
		return null;
	}

	// 상품명으로 검색
	public Product[] list(String sname) {
		int count = 0;
		for (int i = 0; i < cnt; i++) {
			if (products[i].getProductName().contains(sname)) {
				count++;
			}
		}

		Product[] result = new Product[count];
		for (int i = 0, j = 0; i < cnt; i++) {
			if (products[i].getProductName().contains(sname)) {
				result[j++] = products[i];
			}
		}
		return result;
	}

	// TV 정보만 검색
	public Product[] getTVList() {
		int count = 0;
		for (int i = 0; i < cnt; i++) {
			if (products[i] instanceof TV) {
				count++;
			}
		}

		Product[] result = new Product[count];
		for (int i = 0, j = 0; i < cnt; i++) {
			if (products[i] instanceof TV) {
				result[j++] = products[i];
			}
		}
		return result;
	}

	// Refrigerator 정보만 검색
	public Product[] getRefrigeratorList() {
		int count = 0;
		for (int i = 0; i < cnt; i++) {
			if (products[i] instanceof Refrigerator) {
				count++;
			}
		}

		Product[] result = new Product[count];
		for (int i = 0, j = 0; i < cnt; i++) {
			if (products[i] instanceof Refrigerator) {
				result[j++] = products[i];
			}
		}
		return result;
	}

	// 상품 번호로 삭제
	public void delete(int num) {
		for (int i = 0; i < cnt; i++) {
			if (products[i].getProductNo() == num) {
				products[i] = products[--cnt];
				products[cnt] = null;
				System.out.printf("상품 번호 %d번 삭제\n", num);
			}
		}
	}

	// 특정가격 이하의 상품만 조회
	public Product[] priceList(int price) {
		int count = 0;
		for (int i = 0; i < cnt; i++) {
			if (products[i].getPrice() <= price) {
				count++;
			}
		}

		Product[] result = new Product[count];
		int temp = 0;
		for (int i = 0; i < cnt; i++) {
			if (products[i].getPrice() <= price) {
				result[temp++] = products[i];
			}
		}

		return result;
	}

	// 전체 재고 상품 금액의 합
	public long getSumOfProduct() {
		long sum = 0;
		for (int i = 0; i < cnt; i++) {
			sum += products[i].getPrice() * products[i].getQuantity();
		}
		return sum;
	}

}
