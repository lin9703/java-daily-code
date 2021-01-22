package com.java.object.product1;

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
	public void list() {
		System.out.println("----상품 조회----");
		for (int i = 0; i < cnt; i++) {
			System.out.println(products[i]);
		}
	}

	// 상품 번호로 검색
	public void list(int num) {
		System.out.println("----검색 결과----");
		for (int i = 0; i < cnt; i++) {
			if (products[i].getProductNo() == num) {
				System.out.println(products[i]);
			}
		}
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
	public void priceList(int price) {
		System.out.println("----검색 결과----");
		for (int i = 0; i < cnt; i++) {
			if (products[i].getPrice() <= price) {
				System.out.println(products[i]);
			}
		}
	}

}
