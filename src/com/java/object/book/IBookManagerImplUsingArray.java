package com.java.object.book;

import java.util.Arrays;

public class IBookManagerImplUsingArray implements IBookManager {
	static private int MAX_SIZE = 100;
	// Magazine class를 저장하기 위한 별도의 변경 사항 없음 (다형성)
	private Book[] books = new Book[MAX_SIZE];
	private int size;

	// singleton
	private static IBookManagerImplUsingArray manager;

	private IBookManagerImplUsingArray() {
	}

	public static IBookManagerImplUsingArray getInstance() {
		if (manager == null) {
			manager = new IBookManagerImplUsingArray();
		}
		return manager;
	}

	public void add(Book book) {
		if (size <= MAX_SIZE) {
			books[size++] = book;
		}
	}

	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[--size];
				books[size] = null;
			}
		}
	}

	public Book[] getList() {
		return Arrays.copyOf(books, size);
	}

	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

	public Book[] searchByTitle(String title) {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				cnt++;
			}
		}

		Book[] temp = new Book[cnt];
		for (int i = 0, j = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				temp[j++] = books[i];
			}
		}
		return temp;
	}

	public Book[] getBooks() {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}

		Book[] temp = new Book[cnt];
		for (int i = 0, j = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) {
				temp[j++] = books[i];
			}
		}
		return temp;
	}

	public Book[] getMegazines() {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				cnt++;
			}
		}

		Book[] temp = new Book[cnt];
		for (int i = 0, j = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				temp[j++] = books[i];
			}
		}
		return temp;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}

	public double getAvgPrice() {
		return 1.0 * getTotalPrice() / size;
	}

	@Override
	public void save() {
	}
}
