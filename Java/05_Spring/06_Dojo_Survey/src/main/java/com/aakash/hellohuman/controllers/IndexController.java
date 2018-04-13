package com.tony.hellohuman.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class IndexController{
	@RequestMapping("")
	public String index(){
		return "index.jsp";
	}
	
	@RequestMapping(value="/process",method=RequestMethod.POST)
	public String process(@RequestParam(value="name") String name,@RequestParam(value="loc") String loc,@RequestParam(value="lang") String lang,@RequestParam(value="comment",defaultValue="TEST") String comment,HttpSession session){
		session.setAttribute("name",name);
		session.setAttribute("loc",loc);
		session.setAttribute("lang",lang);
		session.setAttribute("comment",comment);
		
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String result(){
		return "result.jsp";
	}
}
