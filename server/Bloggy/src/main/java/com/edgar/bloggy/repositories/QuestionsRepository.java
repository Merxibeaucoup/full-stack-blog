package com.edgar.bloggy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.bloggy.models.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {

}
