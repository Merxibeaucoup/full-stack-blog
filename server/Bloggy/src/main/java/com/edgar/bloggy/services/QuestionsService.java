package com.edgar.bloggy.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.bloggy.models.Questions;
import com.edgar.bloggy.repositories.QuestionsRepository;

@Service
public class QuestionsService {
	
	
	@Autowired
	private QuestionsRepository qRep;
	
	//create
	public Questions addNew(Questions question) {
		return qRep.save(question);
	}
	
	//get all 
	
	public List<Questions> getAll(){
		return qRep.findAll();
	}
	
	//get one by id
	public Questions getOne(long id) {
		return qRep.findById(id).get();
	}
	
	//update one by id
	
	public Questions updateOne(long id, Questions question) {
		 qRep.findById(id);
		 question.setId(id);
		 
		 return qRep.save(question);
	}
	
	//delete one by id
	public void deleteOne(long id) {
		qRep.deleteById(id);
	}
	
	
	

}
