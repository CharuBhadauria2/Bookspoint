package com.point.books.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.point.books.entity.Books;
import com.point.books.service.ActionService;

@Controller
@SessionAttributes("userid")
public class ActionController {
	
	@Autowired
	ActionService actionservice;
	
	
	

	@RequestMapping(value="/Buy", method=RequestMethod.GET)
	public String getBuyPage(ModelMap model,HttpServletRequest request)
	{   if(request.getSession().getAttribute("usersession")==null)
		return "Login";
		String action="Sell";
		model.put("books",actionservice.retrieveBooks(action));
		return "Buy";
	}

	@RequestMapping(value="/Sell", method=RequestMethod.GET)
	public String getSellPage(ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		model.addAttribute("book",new Books());
		return "Sell";
	}
	
//	@RequestMapping(value= {"/Sell","/Lend"}, method=RequestMethod.POST)
//	public String sellOrLendBook(ModelMap model,@RequestParam String title,@RequestParam String author, @RequestParam String category, @RequestParam int price,@RequestParam String action,HttpServletRequest request )
//	{ if(request.getSession().getAttribute("usersession")==null)
//		return "Login";
//		boolean result=actionservice.sellOrLendBook(title, author, category, price,action,model);
//		if(result)
//		model.addAttribute("message", "Book registered for selling /lending successfully");		
//		else
//		model.addAttribute("message", "Books could not be registered successfully. Please try again!");
//		return "Sell";
//	}
	
	
	
	@RequestMapping(value= {"/Sell","/Lend"}, method=RequestMethod.POST)
	public String sellOrLendBook(ModelMap model,@ModelAttribute("book") Books book,HttpServletRequest request ,BindingResult results)
	{ if(request.getSession().getAttribute("usersession")==null)
		return "Login";
		boolean result=actionservice.sellOrLendBook(book.getTitle(), book.getAuthor(), book.getCategory(), book.getPrice(),book.getAction(),model);
		if(result)
		model.addAttribute("message", "Book registered for selling /lending successfully");		
		else
		model.addAttribute("message", "Books could not be registered successfully. Please try again!");
		return "Sell";
	}
	
	@RequestMapping(value="/Borrow", method=RequestMethod.GET)
	public String getBorrowPage(ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		String action="Lend";
		model.put("books",actionservice.retrieveBooks(action));
		return "Buy";
	}
	
	@RequestMapping(value="/Home", method=RequestMethod.GET)
	public String getHomePage(ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		return "Welcome";
	}
	
	@RequestMapping(value="/Lend", method=RequestMethod.GET)
	public String getLendPage(ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		model.addAttribute("book",new Books());
		model.addAttribute("action", "Lend");
		return "Sell";
	}
	
	
	@RequestMapping(value="/MyActions", method=RequestMethod.GET)
	public String getMyActions(ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "redirect:/Login";
		
		String useremail=(String) request.getSession().getAttribute("useremail");
		if(useremail!=null)
		model.put("books",actionservice.retrieveMyActions(useremail));
		
		return "MyActions";
		
	}
	
	@RequestMapping(value="/viewDetails", method=RequestMethod.GET)
	public String getBookDetails(@RequestParam int bookid,ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "redirect:/Login";
		return "redirect:/Home";
				
	}
	

	@RequestMapping(value="/addToCart", method=RequestMethod.GET)
	public String getcart(@RequestParam int bookid,ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		return "redirect:/Home";
				
	}
	
	@RequestMapping(value="/deleteBook", method=RequestMethod.GET)
	public String deleteBook(@RequestParam int id,ModelMap model,HttpServletRequest request)	
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		actionservice.deleteBook(id);
		return "redirect:/MyActions";
		
	}
	
	
	@RequestMapping(value="/updateBook", method=RequestMethod.GET)
	public String updateBook(@RequestParam int id,ModelMap model,HttpServletRequest request)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		
		Books book=actionservice.updateBook(id);
		model.put("book",book);
		return "Sell";
		
		
	}
	
	
	@RequestMapping(value="/updateBook", method=RequestMethod.POST)
	public String updateBookCommit(ModelMap model,Books book,HttpServletRequest request,BindingResult result)
	{
		if(request.getSession().getAttribute("usersession")==null)
			return "Login";
		
		actionservice.updateBookCommit(book,model);
		return "redirect:/MyActions";
		
		
	}
	
	

}
