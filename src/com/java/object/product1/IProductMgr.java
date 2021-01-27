package com.java.object.product1;

import java.util.List;

public interface IProductMgr {

	// 상품 저장
	void addProduct(Product p);

	// 상품 전체 조회 
	List<Product> getList();

	// 상품 번호로 검색
	Product getList(int num);

	// 상품명으로 검색 (부분 검색 가능)
	List<Product> getList(String sname);
	
	// TV 정보만 검색
	List<Product> getTVList();

	// Refrigerator 정보만 검색
	List<Product> getRefrigeratorList();

	// Refrigerator 정보만 검색 (일정 용량 이상)
	List<Product> getRefrigeratorListUsingCapacity(int capacity);
	
	// TV 정보만 검색 (일정 인치 이상)
	List<Product> getTVListUsingInch(int inch);

	// 상품 번호로 상품 가격 변경
	Boolean changePriceUsingProductNo(int productNo);
	
	// 상품 번호로 상품 삭제 
	void deleteProduct(int productNo);

	// 특정가격 이하의 상품만 조회
	List<Product> priceList(int price);

	// 전체 재고 상품 금액의 합
	long getSumOfProduct();

}
