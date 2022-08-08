package com.edgar.bloggy.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.edgar.bloggy.models.Blog;


public class BlogDto {
	
	private long id;
	
	
	@NotBlank
	private String title;
	
	private String body;
	
	private Date date;
	
	private String photo;
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public BlogDto (Blog blog) {
		title = blog.getTitle();
		body = blog.getBody();
		date = blog.getDate();
		photo = blog.getPhoto();
		
	}

}
