package com.tony.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.dojosninjas.services.DojoService;

@Controller
@RequestMapping("/")
public class DojosNinjasController{
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("dojos",dojoService.all());
		return "index";
	}
}
