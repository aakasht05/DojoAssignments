<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create A Ring Of Power</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form id="dashForm" method="POST" action="/dashboard">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<br>
		<input id="back" class="btn btn-link" type="submit" value="Back" />
	</form>
	
	<h2>Forge Ring Of Power</h2>
	
	<form:form action="/admin/${user.id}/rings/new" method="post" modelAttribute="ring">
		<form:label path="name">Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label>
		
		<input type="submit" value="Create"></input>
	</form:form>
</body>
</html>