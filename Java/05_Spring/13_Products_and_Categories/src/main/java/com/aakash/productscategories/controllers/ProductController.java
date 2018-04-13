package com.tony.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tony.productscategories.models.Category;
import com.tony.productscategories.models.Product;
import com.tony.productscategories.services.CategoryService;
import com.tony.productscategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController{
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public String products(Model model){
		model.addAttribute("products",productService.all());
		return "products";
	}

	@RequestMapping("/new")
	public String _new(Model model){
		model.addAttribute("product",new Product());
		return "new_product";
	}
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product,BindingResult res,RedirectAttributes re,Model model){				
		if(res.hasErrors()){
 			re.addFlashAttribute("errs",res.getAllErrors());
		}else{
			productService.create(product);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") long id,Model model){
		model.addAttribute("product",productService.getById(id));
		model.addAttribute("categories",categoryService.all());
		return "show_product";
	}
	
	@PostMapping("/{productId}")
	public String add(@PathVariable("productId") long productId,@RequestParam("category") long categoryId){
		Product product   = productService.getById(productId);
		Category category = categoryService.getById(categoryId);
		List<Category> categories = product.getCategories();
		
		categories.add(category);
		productService.update(product);
		
		return "redirect:/";
	}
}
