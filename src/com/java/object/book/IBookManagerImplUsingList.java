package com.java.object.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IBookManagerImplUsingList implements IBookManager {
	private List<Book> books = null;
	private String file = "./src/com/java/object/book/book.dat";

	// singleton
	private static IBookManagerImplUsingList manager;

	private IBookManagerImplUsingList() {
		load();
	}

	public static IBookManagerImplUsingList getInstance() {
		if (manager == null) {
			manager = new IBookManagerImplUsingList();
		}
		return manager;
	}

	// ./book.data에서 목록 정보를 읽어서 설정
	@SuppressWarnings("unchecked")
	private void load() {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
			Object obj = input.readObject();
			if (obj != null && obj instanceof List) {
				books = (List<Book>) obj;
				System.out.println("기존 데이터 복원");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			books = new ArrayList<>();
			System.out.println("기존 정보가 없어서 새로 생성");
		}
		System.out.println("초기화 종료");
	}

	@Override
	public void save() {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
			output.writeObject(books);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("저장 완료");
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
