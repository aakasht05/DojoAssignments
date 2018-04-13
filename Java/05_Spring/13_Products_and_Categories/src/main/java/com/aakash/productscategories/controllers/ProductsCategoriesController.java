package com.tony.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.productscategories.services.CategoryService;
import com.tony.productscategories.services.ProductService;

@Controller
@RequestMapping("/")
public class ProductsCategoriesController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("categories",categoryService.all());
		model.addAttribute("products", productService.all());
		return "index";
	}
}
