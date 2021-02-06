package com.point.books.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.point.books.service.ActionService;

@Controller
@SessionAttributes("userid")
public class ActionController {
	
	@Autowired
	ActionService actionservice;
	

	@RequestMapping(value="/Buy", method=RequestMethod.GET)
	public String getBuyPage(ModelMap model)
	{  String action="Sell";
		model.put("books",actionservice.retrieveBooks(action));
		return "Buy";
	}
	
	@RequestMapping(value="/Sell", method=RequestMethod.GET)
	public String getSellPage(ModelMap model)
	{
		return "Sell";
	}
	
	@RequestMapping(value= {"/Sell","/Lend"}, method=RequestMethod.POST)
	public String sellOrLendBook(ModelMap model,@RequestParam String title,@RequestParam String author, @RequestParam String category, @RequestParam int price,@RequestParam String action )
	{ boolean result=actionservice.sellOrLendBook(title, author, category, price,action,model);
		if(result)
		model.addAttribute("message", "Book registered for selling /lending successfully");		
		else
		model.addAttribute("message", "Books could not be registered successfully. Please try again!");
		return "Sell";
	}
	
	@RequestMapping(value="/Borrow", method=RequestMethod.GET)
	public String getBorrowPage(ModelMap model)
	{
		String action="Lend";
		model.put("books",actionservice.retrieveBooks(action));
		return "Buy";
	}
	
	@RequestMapping(value="/Home", method=RequestMethod.GET)
	public String getHomePage(ModelMap model)
	{
		return "Welcome";
	}
	
	@RequestMapping(value="/Lend", method=RequestMethod.GET)
	public String getLendPage(ModelMap model)
	{
		model.addAttribute("action", "Lend");
		return "Sell";
	}
	

}
