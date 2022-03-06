package com.point.books.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int bookid;
	
	@Column(name="title")
	String title;
	
	@Column(name="author")
	String author;
	
	@Column(name="category")
	String category;
	
	@Column(name="price")
	int price;
	
	@Column(name="action")
	String action;
	

	
	
	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}
	
	

	public Books(int bookid, String title, String author, String category, int price, String action, UserLogin user) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.action = action;
		this.user = user;
	}
	
	

	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "id")
    private UserLogin user;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAction() {
		return action;
	}

	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", price=" + price + ", action=" + action + ", user=" + user + "]";
	}


	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAction(String action) {  
		this.action = action;
	}

}
