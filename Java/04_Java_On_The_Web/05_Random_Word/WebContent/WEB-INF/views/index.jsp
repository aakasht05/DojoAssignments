<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Index</title>
	</head>

	<body>
	   <p>You have generated a word <c:out value="${count}"/> times.</p>
       <h1><c:out value="${word}"/></h1>
       <p>The last time you generated a word was: <c:out value="${date}"/>.</p>
	   <form method="get" action="/RandomWord/index">
	       <input type="submit" name="submit"></input>
	   </form>
	</body>
</html>