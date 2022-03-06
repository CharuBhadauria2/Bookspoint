package com.point.books.service;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.point.books.entity.UserLogin;

@Component
@Service
@Transactional
@Repository
public class LoginService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired	
	private EntityManager em;
	
	
	public UserLogin validateUser(String userid, String password)
	{
		UserLogin user=repository.findByUsername(userid);
		
		if(user==null)
		{
			return null;
		}
		
		if(!(user.getPassword().equals(password)))
		{
			return null;
		}
		
		return user;
	}
	
	
	
	public boolean saveUser(String fullname,String phoneno, String email, String password)
	{
		
			UserLogin u=new UserLogin();
			u.setFullname(fullname);
			u.setPassword(password);
			u.setPhoneno(phoneno);
			u.setUsername(email);
			u.setRole("user");
			
		
		try {
		//Session session=em.unwrap(Session.class);
		//((EntityManager) session).persist(user);
		repository.save(u);	
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
		
		
	}
	
	public boolean checkUserAlreadyExist(String email, String password)
	{
		if(repository.findByUsername(email)!=null || repository.findByPassword(password)!=null)
	 		 return true;
		
		return false;
		
	}
	
	
	

}
