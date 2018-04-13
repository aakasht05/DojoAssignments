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
	<title>Guild Management</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<form id="dashForm" method="POST" action="/dashboard">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<br>
			<input id="back" class="btn btn-link medFont floatRight" type="submit" value="Back" />
		</form>
		
		<h1 class="center"><c:out value="${guild.name}" /></h1>
		<h3 class="floatRight">Team Status: <c:out value="${guild.users.size()}"/>/<c:out value="${guild.size}"/></h3>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${guild.users}" var="user">
				<c:choose>
					<c:when test="${!user.isAdmin()}">
						<tr>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${Math.floor((curTime - user.createdAt.getTime()) / (1000*60*60*24))} day(s)"/></td>
							<td><a href="/admin/${admin}/delete/${user.id}">Delete</a> | <a href="/admin/${admin}/updater/${user.id}">Update</a></td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</table>
	</div>
</body>
</html>