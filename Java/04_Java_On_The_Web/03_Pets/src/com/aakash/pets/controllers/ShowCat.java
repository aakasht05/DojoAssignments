package com.tony.pets.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tony.pets.models.Cat;

public class ShowCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cat cat = new Cat(
			request.getParameter("name"),
			request.getParameter("breed"),
			Double.parseDouble(request.getParameter("weight"))
		);
		
		request.setAttribute("cat",cat);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Cat.jsp");
		view.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
