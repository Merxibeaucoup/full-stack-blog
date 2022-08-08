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

import com.edgar.bloggy.models.Project;
import com.edgar.bloggy.repositories.ProjectRepository;
import com.edgar.bloggy.services.ProjectService;


@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	
	@Autowired
	private ProjectService pServ;
	
	@Autowired
	private ProjectRepository pRep;
	
	
	//create
	@PostMapping
	public ResponseEntity<Project>  newProject(@Valid @RequestBody Project project){
		Project newProject = pServ.addNew(project);
		return ResponseEntity.ok(newProject);
	}
	
	//get all
	@GetMapping
	public ResponseEntity<List<Project>> getAll(){
		return ResponseEntity.ok(pServ.getAll());
	}
	
	//get one by id 
	@GetMapping("/{id}")
    public ResponseEntity<Project> getByid(@PathVariable long id) {
    	return ResponseEntity.ok(pServ.getOne(id));
    }
	
	//update one by id 
	@PutMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable long id, @RequestBody Project project){
		return ResponseEntity.ok(pServ.updateOne(id, project));
	}
	
	//delete one by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable long id){
		return pRep.findById(id)
		           .map(record -> {
		               pRep.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}
	
	
	

}
