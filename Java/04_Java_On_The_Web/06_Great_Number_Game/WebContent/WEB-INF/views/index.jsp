<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Great Number Game</title>
	</head>
	<style>
	   *{
	       text-align: center;
	       padding: 0;
	       margin: 0;
	   }
	
	   .green{
	       background-color: green;
	       width: 128px;
	       height: 128px;
	   }
	   
	   .red{
	       background-color: red;
           width: 128px;
           height: 128px;
	   }
	</style>
	
	<body>
	   <h1>Welcome to the great number game!</h1>
	   <br>
	   <h2>I am thinking of a number between 1 - 100</h2>
	   <h2>Take a guess!</h2>

        <%String result = (String) session.getAttribute("res");%>

        <%if(result == "You win!"){ %>
            <div class="green"><c:out value="${res}"/> <c:out value="${num}"/> was the number</div>    
        <%}else{%>
            <div class="red"><c:out value="${res}"/></div>    
        <%}%>

	   <form method="POST" action="/GreatNumberGame/index">
	       <input type="number" name="number"></input>
	       <input type="submit" name="submit"></input>
	   </form>
	</body>
</html>