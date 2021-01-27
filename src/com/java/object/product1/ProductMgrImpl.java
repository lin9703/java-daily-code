package com.java.object.product1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> products = new ArrayList<>();

	private static ProductMgrImpl productMgr;

	private ProductMgrImpl() {
	}

	public static ProductMgrImpl getInstance() {
		if (productMgr == null) {
			productMgr = new ProductMgrImpl();
		}
		return productMgr;
	}

	@Override
	public void addProduct(Product p) {
		products.add(p);
	}

	@Override
	public List<Product> getList() {
		return products;
	}

	@Override
	public Product getList(int productNo) {
		for (Product p : products) {
			if (p.getProductNo() == productNo) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Product> getList(String productName) {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p.getProductName().contains(productName)) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public List<Product> getTVList() {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof TV) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public List<Product> getRefrigeratorList() {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof Refrigerator) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public List<Product> getRefrigeratorListUsingCapacity(int capacity) {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof Refrigerator && ((Refrigerator) p).getCapacity() >= 400) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public List<Product> getTVListUsingInch(int inch) {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof TV && ((TV) p).getInch() >= 50) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public boolean changePriceUsingProductNo(int productNo, int price) {
		for (Product p : products) {
			if (p.getProductNo() == productNo) {
				p.setPrice(price);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productNo) {
		for (Product p : products) {
			if (p.getProductNo() == productNo) {
				products.remove(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Product> getListBelowPrice(int price) {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p.getPrice() <= price) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public long getSumOfProduct() {
		long sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += products.get(i).getPrice() * products.get(i).getQuantity();
		}
		return sum;
	}

}
