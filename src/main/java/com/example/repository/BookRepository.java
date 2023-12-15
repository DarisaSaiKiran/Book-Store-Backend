package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	Book findByTitle(String Title);
//	Book findByFeaturedBook(Boolean Featured);
//	  List<Center> findCentersByTestId(Integer testId);
List<Book>findByFeaturedTrue();

}