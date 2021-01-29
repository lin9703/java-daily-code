package com.java.object.book;

public interface IBookManager {

	public void add(Book book);

	public void remove(String isbn);

	public Book[] getList();

	public Book searchByIsbn(String isbn);

	public Book[] searchByTitle(String title);

	public Book[] getBooks();

	public Book[] getMegazines();

	public int getTotalPrice();

	public double getAvgPrice();

	void save();
}
