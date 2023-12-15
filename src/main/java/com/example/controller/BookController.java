package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.BookNotFoundException;
import com.example.exception.ListEmptyException;
import com.example.model.Book;
import com.example.service.BookService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	

	@PostMapping("/addbook")
	public String addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

//	@GetMapping("/all")
//	public ResponseEntity<List<Book>> getBooks() throws ListEmptyException {
//		List<Book> allBooks = bookService.getBooks();
//		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
//	}
	
	@DeleteMapping("/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		return bookService.removeBook(bookId);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) throws BookNotFoundException {
		Book rbook = bookService.getBookById(id);
		return new ResponseEntity<Book>(rbook, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public String updateBook(@PathVariable(value = "id") int id,  @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
@GetMapping("/featured")
public ResponseEntity<List<Book>>getFeaturedBooks(){
	List<Book>featuredBooks=bookService.getFeaturedBooks();
	return ResponseEntity.ok(featuredBooks);

}

@GetMapping("/all")
public ResponseEntity<List<Book>> getBooks()  {
	List<Book> allBooks = bookService.getBooks();
	return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
}
}
