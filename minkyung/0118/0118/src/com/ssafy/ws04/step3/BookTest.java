package com.ssafy.ws04.step3;

import java.io.IOException;
import java.util.ArrayList;

public class BookTest {
	
	public static void main(String[] args) throws QuantityException, ISBNNotFoundException, IOException {
		IBookManager bm = BookManagerImpl.getInstance();
		
//		System.out.println("**********************도서 전체 목록**********************");
//		ArrayList<Book> books = bm.getList();
//		for (Book book : books) {
//			System.out.println(book);
//		}
//		
//		System.out.println("**********************일반 도서 목록**********************");
//		books = bm.getBooks();
//		for (Book book : books) {
//			System.out.println(book);
//		}
//		
//		System.out.println("**********************잡지 목록**********************");
//		books = bm.getMagazines();
//		for (Book book : books) {
//			System.out.println(book);
//		}
//		
//		System.out.println("**********************도서 제목 포함검색:Java**********************");
//		books = bm.searchByTitle("Java");
//		for (Book book : books) {
//			System.out.println(book);
//		}
//		
//		System.out.println("도서 가격 총합: " + bm.getTotalPrice());
//		System.out.println("도서 가격 평균: " + bm.getPriceAvg());
//		
//		bm.remove("21425");
//		
//		System.out.println("**********************삭제 후 도서 전체 목록**********************");
//		books = bm.getList();
//		for (Book book : books) {
//			System.out.println(book);
//		}
//		
//		Book search = bm.searchByIsbn("21424");
//		
//		System.out.println("**********************ISBN 검색**********************");
//		System.out.println(search);
//		
//		System.out.println("**********************도서판매:21424,11개**********************");
//		try {
//			bm.sell("21424", 11);
//		}
//		catch (QuantityException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println("**********************도서구매:21424,10개**********************");
//		bm.buy("21424", 10);
//		
//		System.out.println("**********************도서판매:21424,11개**********************");
//		bm.sell("21424", 11);
//		
//		try {
//			bm.buy("99999", 100);
//		}
//		catch (ISBNNotFoundException e) {
//			System.out.println(e.getMessage() + " : " + e.getIsbn());
//		}
	}
}

