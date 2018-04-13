package com.tony.randomword.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		String cnt = (String) session.getAttribute("count");
		Integer num = 0;
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','m','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
		Random rand = new Random();
		int rndInd = 0;
		String str = "";
		
		if(cnt != null){
			num = Integer.parseInt(cnt);
			num += 1;
			cnt = num.toString();
			session.setAttribute("count",cnt);

		    Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy - hh:mm a");  
			request.setAttribute("date",formatter.format(date));
		}else{
			session.setAttribute("count","0");
			request.setAttribute("date","Never");
		}
		
		for(int i=0;i<14;i++){
			rndInd = rand.nextInt(alphabet.length);
			str += alphabet[rndInd];
		}
		request.setAttribute("word",str);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        view.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
