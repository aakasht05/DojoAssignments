package com.tony.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tony.dojosninjas.models.Dojo;
import com.tony.dojosninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController{
	@Autowired
	private DojoService dojoService;
	
	public DojoController(DojoService dojoService){
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/new")
	public String _new(Model model){
		model.addAttribute("dojo",new Dojo());
		return "new_dojo";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult res,RedirectAttributes re,Model model){
		if(res.hasErrors()){
			re.addFlashAttribute("errs",res.getAllErrors());
		}else{
			dojoService.create(dojo);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") long id,Model model){
		model.addAttribute("dojo",dojoService.getById(id));
		return "show_dojo";
	}
}
