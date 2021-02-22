package com.java.object.product1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.object.book.Book;
import com.java.object.product1.exception.CodeNotFoundException;
import com.java.object.product1.exception.DuplicateException;
import com.java.object.product1.exception.ProductNotFoundException;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> products = null;
	private String file = "./src/com/java/object/product1/product.dat";

	private static ProductMgrImpl productMgr;

	private ProductMgrImpl() {
		load();
	}

	public static ProductMgrImpl getInstance() {
		if (productMgr == null) {
			productMgr = new ProductMgrImpl();
		}
		return productMgr;
	}

	private void load() {
		Thread t = new Thread(() -> {
			try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
				Object obj = input.readObject();
				if (obj != null && obj instanceof List) {
					products = (List<Product>) obj;
					System.out.println("기존 데이터 복원");
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				products = new ArrayList<>();
				System.out.println("기존 정보가 없어서 새로 생성");
			}
			System.out.println("초기화 종료");
		});

		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save() {
		Thread t = new Thread(() -> {
			try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
				output.writeObject(products);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("저장 완료");
		});

		t.start();
	}

	@Override
	public void addProduct(Product p) throws DuplicateException {
		for (Product product : products) {
			if (product.getProductNo() == p.getProductNo()) {
				throw new DuplicateException();
			}
		}
		products.add(p);
	}

	@Override
	public List<Product> getList() {
		return products;
	}

	@Override
	public Product getList(int productNo) throws CodeNotFoundException {
		for (Product p : products) {
			if (p.getProductNo() == productNo) {
				return p;
			}
		}
		throw new CodeNotFoundException(productNo);
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
	public List<Product> getRefrigeratorListUsingCapacity(int capacity) throws ProductNotFoundException {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof Refrigerator && ((Refrigerator) p).getCapacity() >= 400) {
				result.add(p);
			}
		}
		throw new ProductNotFoundException();
	}

	@Override
	public List<Product> getTVListUsingInch(int inch) throws ProductNotFoundException {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof TV && ((TV) p).getInch() >= 50) {
				result.add(p);
			}
		}
		throw new ProductNotFoundException();
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
