package com.edgar.bloggy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.bloggy.models.Project;
import com.edgar.bloggy.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	
	
	@Autowired
	private ProjectRepository pRep;
	
	//create
	public Project addNew(Project project) {
		return pRep.save(project);
	}
	
	//get all
	public List<Project> getAll(){
		return pRep.findAll();
	}
	
	//get one by id
	public Project getOne(long id) {
		return pRep.findById(id).get();
	}
	
	//update one by id
	public Project updateOne(long id, Project project) {
		pRep.findById(id);
		project.setId(id);
		
		return pRep.save(project);
		
	}
	
	//delete one
	public void deleteOne(long id) {
		pRep.deleteById(id);
	}

}
