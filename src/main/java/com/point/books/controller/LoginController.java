package com.point.books.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.ModelAndView;

import com.point.books.entity.UserLogin;
import com.point.books.service.LoginService;
import com.point.books.service.UserRepository;

@Controller
@SessionAttributes("userid")
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginMessagedefault(ModelMap model) {
		return "redirect:Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String loginMessage(ModelMap model,  HttpSession session) {
		if(session.getAttribute("usersession")!=null)
			session.invalidate();
		return "Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView postloginMessage(ModelMap model, @RequestParam String name, @RequestParam String password,
			HttpServletRequest request) {

		UserLogin user = service.validateUser(name, password);
		if (null == user) {
			model.addAttribute("error", "error");
			return new ModelAndView("Login", model);	

		} else {
			model.put("username", user.getFullname());
			model.put("userid", user.getId());
			request.getSession().setAttribute("usersession",user.getFullname());
			request.getSession().setAttribute("useremail",user.getUsername());
			return new ModelAndView("redirect:/Home");
		}

	}

	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public String showRegisterPage(ModelMap model) {
	
		return "Register";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST, consumes = { "application/x-www-form-urlencoded",
			"application/json" })
	public ModelAndView registerUser(ModelMap model, @RequestParam String fullname, @RequestParam String phoneno,
			@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
		boolean alreadyExists = service.checkUserAlreadyExist(email, password);
		if (alreadyExists) {
			model.addAttribute("alreadyexists", "alreadyexists");
			return new ModelAndView("Register", model);	

		}

		boolean isSaved = service.saveUser(fullname, phoneno, email, password);

		if (isSaved) {
			model.put("username", fullname);
			request.getSession().setAttribute("usersession", fullname);
			request.getSession().setAttribute("useremail",email);
			return new ModelAndView("redirect:/Home");
		} else {
			model.addAttribute("errorreg", "errorreg");
			return new ModelAndView("Register",model);		}
	}

	@RequestMapping(value = "/Help", method = RequestMethod.GET)
	public String showHelpPage(ModelMap model) {
		return "Help";
	}

	@RequestMapping(value = "/Error", method = RequestMethod.GET)
	public String errorpage(ModelMap model) {
		return "error";
	}

}
