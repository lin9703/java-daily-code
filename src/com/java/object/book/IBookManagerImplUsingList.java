package com.java.object.book;

import java.util.ArrayList;
import java.util.List;

public class IBookManagerImplUsingList implements IBookManager {
	List<Book> books = new ArrayList<>();

	// singleton
	private static IBookManagerImplUsingList manager;

	private IBookManagerImplUsingList() {
	}

	public static IBookManagerImplUsingList getInstance() {
		if (manager == null) {
			manager = new IBookManagerImplUsingList();
		}
		return manager;
	}

	@Override
	public void add(Book book) {
		books.add(book);
	}

	@Override
	public void remove(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				books.remove(book);
				return;
			}
		}
	}

	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().contains(title)) {
				result.add(book);
			}
		}
		return result.toArray(new Book[books.size()]);
	}

	@Override
	public Book[] getBooks() {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (!(book instanceof Magazine)) {
				result.add(book);
			}
		}
		return result.toArray(new Book[books.size()]);
	}

	@Override
	public Book[] getMegazines() {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book instanceof Magazine) {
				result.add(book);
			}
		}
		return result.toArray(new Book[books.size()]);
	}

	@Override
	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public double getAvgPrice() {
		return 1.0 * getTotalPrice() / books.size();
	}

}
