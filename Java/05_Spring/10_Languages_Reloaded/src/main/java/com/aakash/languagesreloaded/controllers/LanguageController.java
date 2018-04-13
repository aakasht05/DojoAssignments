package com.tony.languagesreloaded.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tony.languagesreloaded.models.Language;
import com.tony.languagesreloaded.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	private LanguageService languageService;
	
	public LanguageController(LanguageService languageService){
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String languages(Model model){
		model.addAttribute("language",new Language());
		model.addAttribute("languages",languageService.all());
		return "languages";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("language") Language language,BindingResult res,RedirectAttributes flash){
		if(res.hasErrors()){
			flash.addFlashAttribute("errs",res.getAllErrors());
		}else{
			languageService.create(language);
		}
		
		return "redirect:/languages";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") long id,Model model){
		Language language = languageService.getByIndex(id);		
		model.addAttribute("language",language);
		return "show";
	}
	
	@RequestMapping("/delete/{id}")
	public String destroy(@PathVariable("id") long id){
		languageService.destroy(id);
		return "redirect:/languages";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id,Model model){
		Language language = languageService.getByIndex(id);
		model.addAttribute("language",language);
		return "edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("language") Language language,BindingResult res,RedirectAttributes flash){
		if(res.hasErrors()){
			flash.addFlashAttribute("errs",res.getAllErrors());
		}else{
			languageService.update(language);
		}
		
		return "redirect:/languages";
	}
}
