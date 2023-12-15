package com.example.exception;

import java.util.List;

import com.example.model.Book;


public class ListEmptyException extends Exception {
	public ListEmptyException() {
		super();
	}

	private static final long serialVersionUID = 8888435367687861212L;

	public ListEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public static boolean checkBooks(List<Book> allBooks) {

		if (allBooks.isEmpty()) {
			return true;
		}
		return false;
	}
}