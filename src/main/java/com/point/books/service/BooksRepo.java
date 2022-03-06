package com.point.books.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.point.books.entity.Books;
import com.point.books.entity.UserLogin;

public interface BooksRepo extends JpaRepository<Books, Integer>{
	
	List<Books> findByAction(String action);
	
	List<Books> findByUser(UserLogin user);
	
	Books findById(int bookid);
	
}
