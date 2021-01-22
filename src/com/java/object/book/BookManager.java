package com.java.object.book;

import java.util.Arrays;

public class BookManager {
	static private int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	
	private static BookManager manager;
	
	private BookManager() {}
	
	public static BookManager getInstance() {
		if(manager==null) {
			manager = new BookManager();
		}
		return manager;
	}
	
	public void add(Book book) {
		if(size <= MAX_SIZE) {
			books[size++] = book;
		}
	}
	
	public void remove(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[--size];
				books[size] = null;
			}
		}
	}
	
	public Book[] getList() {
		return Arrays.copyOf(books, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}
