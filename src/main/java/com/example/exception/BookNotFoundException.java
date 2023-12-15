package com.example.exception;

import java.util.List;

import com.example.model.Book;

public class BookNotFoundException extends Exception {

	public BookNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 8888435367687861212L;

	
	public BookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public static boolean checkIfBookExist(List<Book> allBooks, int id) {
		boolean bookExists = allBooks.stream().filter(s -> s.getId().equals(id)).findFirst().isPresent();
		return bookExists;
	}
}
