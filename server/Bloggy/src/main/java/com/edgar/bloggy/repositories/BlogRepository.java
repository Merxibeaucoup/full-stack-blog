package com.edgar.bloggy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.bloggy.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
