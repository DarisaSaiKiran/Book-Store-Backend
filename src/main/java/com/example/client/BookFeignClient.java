package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Book;

@FeignClient(name = "book-service", url = "http://localhost:8081")
public interface BookFeignClient {
    @GetMapping("/books/{bookId}")
    Book getBookById(@PathVariable("bookId") Long bookId);
}
