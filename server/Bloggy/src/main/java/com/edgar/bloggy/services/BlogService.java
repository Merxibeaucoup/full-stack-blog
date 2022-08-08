package com.edgar.bloggy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.bloggy.models.Blog;
import com.edgar.bloggy.repositories.BlogRepository;

@Service
public class BlogService {
	
	
	@Autowired
	private BlogRepository blogRepo;
	
	
	//create
	 public Blog addNew(Blog blog) {
		 return blogRepo.save(blog);
	 }
	
	
	//list all
	 
	 public List<Blog> listAll(){
		 return blogRepo.findAll();
	 }
	
	// get one by id 
	 public Blog getById(long id) {
		 return blogRepo.findById(id).get();
	 }
	
	// update 
	 public Blog updateById( long id, Blog blog ) {
		 blogRepo.findById(id);
		 blog.setId(id);
		 
		 return blogRepo.save(blog);
	 }
	
	//delete by id 
	 
	 public void deleteById(long id) {
		 blogRepo.deleteById(id);
	 }
	 
	
	 	

}
