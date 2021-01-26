package com.java.object.book;

public class BookTest {

	public static void main(String[] args) {
		BookManager manager = BookManager.getInstance();

		manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		manager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));

		// Magazine is a Book이기 때문에 available
		Magazine ma1 = new Magazine("12132", "유명인 잡지", "김소리", "jaen.kr", 10000, "만화책", 2021, 1);
		manager.add(ma1);

		Book[] books = manager.getList();
		System.out.println("**********도서목록*********");
		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i]);
		}

		String searchIsbn = "21424";
		System.out.printf("**********도서조회:%s*********\n", searchIsbn);
		System.out.println(manager.searchByIsbn(searchIsbn));

		String removeIsbn = "21424";
		System.out.printf("**********도서삭제:%s*********\n", removeIsbn);
		manager.remove(removeIsbn);

		books = manager.getList();
		System.out.println("**********도서목록*********");
		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i]);
		}

	}

}
