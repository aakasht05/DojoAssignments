package com.tony.productscategories.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.productscategories.models.Category;
import com.tony.productscategories.models.Product;
import com.tony.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductService productService;
	
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) categoryRepository.findAll();
	}
	
	public Category getById(long id){
		return categoryRepository.findOne(id);
	}
	
	public void create(Category category){
		categoryRepository.save(category);
	}
	
	public void update(Category category){
		categoryRepository.save(category);
	}
	
	public void destroy(long id){
		categoryRepository.delete(id);
	}
}
