package com.point.books.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.point.books.entity.Books;

public interface BooksRepo extends JpaRepository<Books, Integer>{
	
	List<Books> findByAction(String action);

}
