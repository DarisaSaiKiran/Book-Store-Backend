package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.BookNotFoundException;
import com.example.exception.ListEmptyException;
import com.example.model.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	 

	@Autowired
	BookRepository bookRepository;
	private static final String DEFAULT_IMAGE_URL = "https://w7.pngwing.com/pngs/360/232/png-transparent-computer-icons-the-book-thief-book-angle-rectangle-curriculum-thumbnail.png";

	public String addBook(Book book) {
		Book anotherBook = bookRepository.findByTitle(book.getTitle());
		if (anotherBook != null) {
			return "Book already exists please try again";
		}
		  // Set default profile image URL if the user doesn't provide a URL
	    if (book.getImageUrl() == null || book.getImageUrl().isEmpty()) {
	        book.setImageUrl(DEFAULT_IMAGE_URL);
	    }

		String bookName = book.getTitle();
		bookRepository.save(book);
		return "Book added succesfully";
	}
	
public List<Book> getFeaturedBooks(){
	return bookRepository.findByFeaturedTrue();

}
	
	public List<Book> getBooks() {
		
		return bookRepository.findAll();
	}
	
	public String removeBook(Integer bookId) {
		Book book = bookRepository.getReferenceById(bookId);
		if (bookRepository.existsById(bookId)) {
			bookRepository.deleteById(bookId);
			return "Book " + bookId + " deleted successfully";
		} else
			return "Book does not exists";
	}
	
	public Book getBookById(int id) throws BookNotFoundException {
		List<Book> allBooks = bookRepository.findAll();
		if (!BookNotFoundException.checkIfBookExist(allBooks, id)) {
			throw new BookNotFoundException("No details found for the given ID");
		}
		return bookRepository.findById(id).get();
	}
	
	public String updateBook(Integer id, Book book) {
		Book b = bookRepository.getReferenceById(id);
		if (bookRepository.existsById(id)) {
			if (book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getImageUrl().isEmpty()
					) {
				return "Please fill all fields";
			} else {
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
			b.setImageUrl(book.getImageUrl());
			b.setPrice(book.getPrice());
			b.setFeatured(book.isFeatured());
			bookRepository.save(b);
			return "Book Updated Succesfully" ;
			}

		} else {
			return "BookID Not Found";
		}
	}
}
