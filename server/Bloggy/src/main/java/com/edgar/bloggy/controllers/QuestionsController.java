package com.edgar.bloggy.controllers;

import java.util.List;

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

import com.edgar.bloggy.models.Questions;
import com.edgar.bloggy.repositories.QuestionsRepository;
import com.edgar.bloggy.services.QuestionsService;

@RestController
@RequestMapping("/api/question")
public class QuestionsController {
	
	//service
	@Autowired
	private QuestionsService qServ;
	
	//repo
	@Autowired
	private QuestionsRepository qRep;
	
	
	//create
	@PostMapping
	public ResponseEntity<Questions> newQuestion(@Valid @RequestBody Questions question){
		Questions newQuestion = qServ.addNew(question);
        return ResponseEntity.ok(newQuestion);
	}
	
	//get all
	@GetMapping
	public ResponseEntity<List<Questions>> getAll(){
		return ResponseEntity.ok(qServ.getAll());
	}
	
	//get one by id
	@GetMapping("/{id}")
	public ResponseEntity<Questions> getOne(@PathVariable long id ){
		return ResponseEntity.ok(qServ.getOne(id));
	}
	
	//update one by id
	@PutMapping("/{id}")
	public ResponseEntity<Questions> updateQuestion(@PathVariable long id, @Valid @RequestBody Questions question){
		return ResponseEntity.ok(qServ.updateOne(id, question));
	}
	
	
	//delete one by id 
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable long id){
		return qRep.findById(id)
		           .map(record -> {
		               qRep.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}
	
	
	

}
