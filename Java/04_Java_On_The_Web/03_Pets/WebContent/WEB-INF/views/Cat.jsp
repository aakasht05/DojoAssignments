<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cat</title>
        <link href="{pageContext.request.contextPath}/static/style.css" rel="stylesheet" type="text/css"></link>
	</head>
	
	<body>
        <h1><c:out value="${cat.showAffection()}"/></h1>
	</body>
</html>