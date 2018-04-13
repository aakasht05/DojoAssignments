package com.tony.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/SimpleProject/Home?first=Tony&last=Morris&lang=C&town=Rockville

@WebServlet("/home")
public class Home extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first    = request.getParameter("first") == null ? "unknown":request.getParameter("first");
		String last     = request.getParameter("last") == null ? "unknown":request.getParameter("last");
		String favLang  = request.getParameter("lang") == null ? "unknown":request.getParameter("lang");
		String homeTown = request.getParameter("town") == null ? "unknown":request.getParameter("town");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(
			"<h1>Hello, "+first+" "+last+"</h1>"+"<br>"+
			"<h2>Your favorite language is: "+favLang+"</h2>"+"<br>"+
			"<h2>Your hometown is: "+homeTown+"</h2>"
		);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
