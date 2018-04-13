package com.tony.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("")
	public String index(){
		
		return "index";
	}

	@RequestMapping("/process")
	public String process(@RequestParam(value="code") String code,RedirectAttributes attr){
		String b = "bushido";

		if(code.equals(b)){
			return "redirect:/code";
		}else{
			attr.addFlashAttribute("err","You must train harder!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String code(){
		
		return "code";
	}
}
