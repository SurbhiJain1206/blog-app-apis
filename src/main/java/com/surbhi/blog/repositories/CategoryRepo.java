package com.surbhi.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surbhi.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	

}
