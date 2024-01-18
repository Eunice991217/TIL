package com.ssafy.ws04.step3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.ssafy.ws04.step3.Book;

public class BookManagerImpl implements IBookManager {

	ArrayList<Book> books;

	private static IBookManager bookManagerInstance;

	public static IBookManager getInstance() {
		if (bookManagerInstance == null) {
			bookManagerInstance = new BookManagerImpl(); // null 일때만 한번만 만들어주고
			
		}
		return bookManagerInstance;
	}

	private BookManagerImpl() {
		books = new ArrayList<>();
		MyLoadThread loadThread = new MyLoadThread();
        loadThread.start(); // 사용자 정의 스레드 실행 
        try {
			loadThread.join(); // main thread 잠시 중단시켜두고 loadThread가 끝나면 main Thread 실행  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private class MyLoadThread extends Thread {
        @Override
        public void run() {
            loadData();
        }
    }

	public void saveData() throws IOException {
        File file1 = new File("book.dat");

        try {
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(books);
            oos.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	private void loadData() {
		File file1 = new File("book.dat");
        if (file1.exists()) {
            try {
            	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1));
            	books = (ArrayList<Book>) ois.readObject();
                System.out.println("**********************도서 전체 목록**********************");
                for (Book book : books) {
                    System.out.println(book);
                }
            } catch (IOException | ClassNotFoundException e) {
            	System.out.println(e.getMessage());
            }
        } else {
        	try {
        		add(new Book("21424", "Java Pro", "김하나", "ssafy.kr", 15000, "Java 기본 문법", 10));
        		add(new Book("21425", "Java Pro2", "김하나", "ssafy.kr", 25000, "Java 응용", 20));
        		add(new Book("35355", "분석설계", "소나무", "ssafy.kr", 30000, "SW 모델링", 30));
        		add(new Magazine("45678", "월간 알고리즘", "홍길동", "ssafy.kr", 10000, "1월 알고리즘", 40, 2021, 1));
        		       		
				saveData();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	System.out.println("**********************불러온 전체 목록**********************");
            System.out.println("등록된 도서가 없습니다.");
        }
	}
	
	

	@Override
	public void add(Book book) {
		if (book != null) {
			books.add(book);
		}
	}

	@Override
	public synchronized void remove(String isbn) {
		int tmpIndex = 0;
		Book tmpBook;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().contains(isbn)) {
				tmpIndex = i;
				break;
			}
		}

		if (tmpIndex == 0) { // tmpIndex가 업데이트되었다면 (찾은 경우)
			books.remove(tmpIndex); // List 에서 해당 인덱스의 요소를 제거
		}
	}

	@Override
	public ArrayList<Book> getList() {
		return books;
	}

	@Override
	public Book searchByIsbn(String isbn) {
		Book book = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null && books.get(i).getIsbn().equals(isbn)) {
				book = books.get(i);
				break; // 중복된 ISBN이 없다고 가정하고 검색 중지
			}
		}
		return book;
	}

	@Override
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> titleList = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().contains(title)) {
				titleList.add(books.get(i));
			}
		}
		return titleList;
	}

	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> bookList = new ArrayList<>();

		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine)) {
				bookList.add(books.get(i));
			}
		}

		return bookList;
	}

	@Override
	public ArrayList<Book> getMagazines() {
		ArrayList<Book> MagazineList = new ArrayList<>();

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine) {
				MagazineList.add(books.get(i));
			}
		}

		return MagazineList;
	}

	@Override
	public int getTotalPrice() {
		int totalPrice = 0;
		for (int i = 0; i < books.size(); i++) {
			totalPrice += books.get(i).getPrice();
		}
		return totalPrice;
	}

	@Override
	public double getPriceAvg() {
		double avgPrice = 0.0;
		avgPrice = (double) getTotalPrice() / books.size();
		return avgPrice;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book tmpBook = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				tmpBook = books.get(i);
				break;
			}
		}

		if (tmpBook == null) { // 도서의 ISBN이 존재하지 않는
			throw new ISBNNotFoundException(isbn);
		}

		int diff = tmpBook.getQuantity() - quantity;

		if (diff < 0) {
			throw new QuantityException();
		} else {
			tmpBook.setQuantity(diff);
			System.out.println(tmpBook.toString());
		}

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book tmpBook = null;

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				tmpBook = books.get(i);
				break;
			}
		}

		if (tmpBook == null) { // 도서의 ISBN이 존재하지 않는
			throw new ISBNNotFoundException(isbn);
		}

		tmpBook.setQuantity(tmpBook.getQuantity() + quantity);

		System.out.println(tmpBook.toString());

	}
}
