package com.java.object.product1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ProductMgr management = ProductMgr.getInstance();

		// 상품 저장 테스트
		System.out.println("저장할 상품의 개수(정수)를 입력해주세요.");
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		System.out.println("\n입력하고자 하는 상품의 상품번호, 상품이름, 가격, 수량 정보를 적어주세요. (상품은 엔터로 구분)");
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			management.add(new Product(Integer.parseInt(st.nextToken()), st.nextToken(),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// 상품 조회
		management.list();

		// 상품 번호로 검색
		System.out.println("\n검색하고자 하는 상품의 상품번호를 적어주세요.");
		st = new StringTokenizer(br.readLine());
		management.list(Integer.parseInt(st.nextToken()));

		// 상품 번호로 삭제
		System.out.println("\n삭제하고자 하는 상품의 상품번호를 적어주세요.");
		st = new StringTokenizer(br.readLine());
		management.delete(Integer.parseInt(st.nextToken()));
		management.list();

		// 특정 가격 이하의 상품만 검색
		System.out.println("\n얼마 이하의 상품을 검색하고 싶은지 적어주세요.");
		st = new StringTokenizer(br.readLine());
		management.priceList(Integer.parseInt(st.nextToken()));
	}

}
