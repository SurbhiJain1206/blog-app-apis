package com.surbhi.blog.services;

import java.util.List;



import com.surbhi.blog.payloads.CategoryDto;
//import com.surbhi.blog.repositories.CategoryRepo;

public interface CategoryService {

	
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//get all
	List<CategoryDto> getCategories();

}
