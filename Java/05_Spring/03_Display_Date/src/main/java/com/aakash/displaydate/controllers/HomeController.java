package com.tony.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/")
public class HomeController{
	@RequestMapping("")
	public String index(){
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model){
	    Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		model.addAttribute("date",formatter.format(date));
		return "_date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model){
	    Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
		model.addAttribute("time",formatter.format(date));
		return "_time.jsp";
	}
}

