package com.java.object.product1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class ProductTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ProductMgrImpl management = ProductMgrImpl.getInstance();

		// 상품 저장 테스트
		System.out.println("저장할 상품의 개수(정수)를 입력해주세요.");
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		System.out.println("\n입력하고자 하는 상품의 종류, 상품번호, 상품이름, 가격, 수량 정보를 적어주세요. (상품은 엔터로 구분)");
		System.out.println("Product: 1, TV: 2, Refrigerator: 3");

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				management.addProduct((new Product(Integer.parseInt(st.nextToken()), st.nextToken(),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
				break;
			case 2:
				management.addProduct(new TV(Integer.parseInt(st.nextToken()), st.nextToken(),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				break;
			case 3:
				management.addProduct(new Refrigerator(Integer.parseInt(st.nextToken()), st.nextToken(),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
				break;

			}
		}

		// 상품 조회
		System.out.println("----상품 조회----");
		List<Product> list = management.getList();
		for (Product p : list) {
			System.out.println(p);
		}

		// 상품 번호로 검색
		System.out.println("\n검색하고자 하는 상품의 상품번호를 적어주세요.");
		st = new StringTokenizer(br.readLine());
		System.out.println("----검색 결과----");
		System.out.println(management.getList(Integer.parseInt(st.nextToken())));

		// 상품명으로 검색
		System.out.println("\n검색하고자 하는 상품의 상품명을 적어주세요.(부분 검색 가능)");
		st = new StringTokenizer(br.readLine());
		System.out.println("----검색 결과----");
		list = management.getList(st.nextToken());
		for (Product p : list) {
			System.out.println(p);
		}

		// TV 정보만 조회
		System.out.println("\n----TV 상품 조회----");
		list = management.getTVList();
		for (Product p : list) {
			System.out.println(p);
		}

		// Refrigerator 정보만 조회
		System.out.println("\n----Refrigerator 상품 조회----");
		list = management.getRefrigeratorList();
		for (Product p : list) {
			System.out.println(p);
		}

		// Refrigerator 정보만 검색 (일정 용량 이상)
		System.out.println("\nRefrigerator의 용량 기준을 적어주세요.");
		st = new StringTokenizer(br.readLine());
		System.out.println("----검색 결과----");
		list = management.getRefrigeratorListUsingCapacity(Integer.parseInt(st.nextToken()));
		for (Product p : list) {
			System.out.println(p);
		}

		// TV 정보만 검색 (일정 인치 이상)
		System.out.println("\nTV의 인치 기준을 적어주세요.");
		st = new StringTokenizer(br.readLine());
		System.out.println("----검색 결과----");
		list = management.getTVListUsingInch(Integer.parseInt(st.nextToken()));
		for (Product p : list) {
			System.out.println(p);
		}

		// 상품 번호로 상품 가격 변경
		System.out.println("\n변경하고자 하는 상품의 상품번호와 가격을 적어주세요.");
		st = new StringTokenizer(br.readLine());
		management.changePriceUsingProductNo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		System.out.println("----상품 조회----");
		list = management.getList();
		for (Product p : list) {
			System.out.println(p);
		}

		// 상품 번호로 상품 삭제
		System.out.println("\n삭제하고자 하는 상품의 상품번호를 적어주세요.");
		st = new StringTokenizer(br.readLine());
		management.deleteProduct(Integer.parseInt(st.nextToken()));
		System.out.println("----상품 조회----");
		list = management.getList();
		for (Product p : list) {
			System.out.println(p);
		}

		// 특정 가격 이하의 상품만 검색
		System.out.println("\n얼마 이하의 상품을 검색하고 싶은지 적어주세요.");
		st = new StringTokenizer(br.readLine());
		List<Product> priceList = management.getListBelowPrice((Integer.parseInt(st.nextToken())));
		System.out.println("----상품 조회----");
		for (Product p : priceList) {
			System.out.println(p);
		}

		// 전체 재고 상품 금액의 합
		System.out.println("\n----전체 재고 상품 금액의 합----");
		System.out.printf("%d원\n", management.getSumOfProduct());

	}

}
