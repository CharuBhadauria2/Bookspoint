   package com.point.books.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_login")
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Column
	private String phoneno;
	
	@Column
	private String fullname;
	

	public UserLogin(long id, String username, String password, String role, String phoneno, String fullname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.phoneno = phoneno;
		this.fullname = fullname;
	}


	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", phoneno=" + phoneno + ", fullname=" + fullname + "]";
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserLogin() {
		
	}

}
