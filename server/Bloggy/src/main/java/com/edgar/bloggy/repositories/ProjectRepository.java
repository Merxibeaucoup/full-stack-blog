package com.edgar.bloggy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.bloggy.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
