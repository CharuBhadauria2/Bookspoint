package com.point.books.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.point.books.entity.Books;
import com.point.books.entity.UserLogin;

@Component
@Service
@Repository
@SessionAttributes("userid")
public class ActionService {
	
	
	@Autowired
	BooksRepo br;
	
	@Autowired
	UserRepository repository;
	
	public boolean sellOrLendBook(String title, String author, String category, int price, String action,ModelMap model)
	{
		Books b=new Books();
		
		long uid=Long.parseLong(model.get("userid").toString());
		b.setAuthor(author);
		b.setTitle(title);
		b.setCategory(category);
		b.setPrice(price);
		b.setAction(action);
		
		UserLogin user=repository.findById(uid);
		b.setUser(user);
		
		
		try {
		br.save(b);
		return true;
		
		}
		catch(Exception e)
		{
		   System.out.println(e.getMessage());
		   return false;
		   
		}
		
	}
	
	
	
	
	
	public List<Books> retrieveBooks(String action)
	{
		List<Books> books=new ArrayList<Books>();
		
		books= br.findByAction(action);
		return books;
		
	}
	
	
	
	

}
