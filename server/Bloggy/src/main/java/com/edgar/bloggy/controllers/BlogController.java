package com.edgar.bloggy.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.bloggy.models.Blog;
import com.edgar.bloggy.repositories.BlogRepository;
import com.edgar.bloggy.services.BlogService;



@RestController
@RequestMapping("/api/blog")
public class BlogController {
	
	@Autowired
	private BlogService bServ;
	
	@Autowired
	private BlogRepository bRep;
	
	
    
    //get all 
    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
    	return ResponseEntity.ok(bServ.listAll());
    }
    
    // get one 
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getByid(@PathVariable long id) {
    	return ResponseEntity.ok(bServ.getById(id));
    }
    
    // create  
    @Transactional
	@PostMapping
	public ResponseEntity<Blog> create(@Valid @RequestBody Blog blog){
        Blog newBlog = bServ.addNew(blog);
        return ResponseEntity.ok(newBlog);
    }
    
    //delete by id
    @DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return bRep.findById(id)
	           .map(record -> {
	               bRep.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
    
    //update by id
    
    @PutMapping("/{id}")
    public ResponseEntity<Blog>  update(@PathVariable long id, @RequestBody Blog blog) {
    	return ResponseEntity.ok(bServ.updateById(id, blog));
    }
   

}
