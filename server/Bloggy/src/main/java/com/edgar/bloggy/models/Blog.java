package com.edgar.bloggy.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Blog  {
	
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	

	@NotBlank(message ="please enter a title for your blog")
	@Column
	private String title;
	
	
	@NotBlank(message= " Blog body cannot be empty")
	@Column(columnDefinition="TEXT")
	private String body;
	
	@CreationTimestamp // sets to current vm time stamp
	@Temporal(TemporalType.TIMESTAMP)// get sql time stamp 
	@JsonFormat(pattern ="MM-dd-yyyy")
	@Column(nullable = true)
	private Date date; // date created
	

	
	private String photo;
	
	public Blog() {
		
	}

	public Blog( @NotBlank(message = "please enter a title for your blog") String title,
			@NotBlank(message = " Blog body cannot be empty") String body, Date date, String photo) {
		super();
		
		this.title = title;
		this.body = body;
		this.date = date;
		this.photo = photo;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public int hashCode() {
		return Objects.hash(body, date, photo, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		return Objects.equals(body, other.body) && Objects.equals(date, other.date) 
				&& Objects.equals(photo, other.photo) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Blog [ title=" + title + ", body=" + body + ", date=" + date + ", photo=" + photo + "]";
	}
	
	

}
