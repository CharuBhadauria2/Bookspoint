package com.point.books.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.point.books.entity.UserLogin;
import com.point.books.service.LoginService;
import com.point.books.service.UserRepository;

@Controller
@SessionAttributes("userid")
public class LoginController {
	
	
	@Autowired
	LoginService service;
	
	
	
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String loginMessage(ModelMap model)
	{
		return "Login";
	}
	@RequestMapping(value="/Logout", method=RequestMethod.GET)
	public String logoutMessage(ModelMap model)
	{
		return "Login";
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public String postloginMessage(ModelMap model,@RequestParam String name,@RequestParam String password)
	{
		
	UserLogin user=service.validateUser(name, password);
	if(null==user)
		{
		model.addAttribute("error", "error");
		return "Login";
		
		}
	else
	{model.put("username",user.getFullname());
	 model.put("userid",user.getId());
		return "Welcome";
	}
		
	}
	
	
	@RequestMapping(value="/Register", method=RequestMethod.GET)
	public String showRegisterPage(ModelMap model)
	{
		//UserLogin user=new UserLogin();
		//model.addAttribute("user",user);
		return "Register";
	}
	
	/*@RequestMapping(value="/Register", method=RequestMethod.POST, consumes = {"application/x-www-form-urlencoded","application/json"})
	public String registerUser(ModelMap model,@RequestBody MultiValueMap<String, String> body)
	{
		boolean isSaved=service.saveUser(body);
		
		if(isSaved)
		{model.put("name",body.get("fullname"));
			return "Welcome";
		}
			else
			{model.addAttribute("errorreg","errorreg");		
		return "Register";
			}
	}*/
	
	@RequestMapping(value="/Register", method=RequestMethod.POST, consumes = {"application/x-www-form-urlencoded","application/json"})
	public String registerUser(ModelMap model,@RequestParam String fullname,@RequestParam String phoneno,@RequestParam String email,@RequestParam String password)
	{  
		boolean isSaved=service.saveUser(fullname,phoneno,email,password);
		
		if(isSaved)
		{model.put("username",fullname);
			return "Welcome";
		}
			else
			{model.addAttribute("errorreg","errorreg");		
		return "Register";
			}
	}
	
	

	@RequestMapping(value="/Help", method=RequestMethod.GET)
	public String showHelpPage(ModelMap model)
	{
		return "Help";
	}
	
}
