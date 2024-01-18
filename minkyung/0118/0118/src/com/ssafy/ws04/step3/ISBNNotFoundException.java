package com.ssafy.ws04.step3;

@SuppressWarnings("serial")
public class ISBNNotFoundException extends Exception{
	String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super("사용자가 없습니다.");
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
}


