<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE HTML>
<html>
<head>
	<title>RINGS OF POWER</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<form id="logoutForm" method="POST" action="/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<br>
			<input id="logout" class="btn btn-link" type="submit" value="Logout" />
		</form>

		<h1>Welcome, <c:out value="${user.firstName}"/> <c:out value="${user.lastName}" /> </h1>
		<p>
			Welcome to your awesome magical ring finder. Put the ring on and only good things will happen.
			Maybe it'll make you live forever, go invisible, turn your inherent hunger for riches or power into an insatiable
			curse that eventually dooms your entire species.
		</p>

	    <c:if test="${ringDelay != null}">
			<div class="alert alert-danger alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				<c:out value="${ringDelay}"></c:out>
			</div>
	    </c:if>
	    <c:if test="${userOnly != null}">
			<div class="alert alert-danger alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				<c:out value="${userOnly}"></c:out>
			</div>
	    </c:if>

		<form action="/users/${user.id}/rings/add" method="post">
			<label for="ring">Rings Of Power
				<select id="ring" name="ring">
					<c:forEach items="${rings}" var="ring">
						<option value="${ring[0]}"> <c:out value="${ring[1]}" /> </option>
					</c:forEach>
				</select>
			</label>
			<input type="submit" value="BIND YOURSELF IN DARKNESS"></input>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		
		<c:choose>
			<c:when test="${user.isAdmin()}">
				<h3><a href="/admin/${user.id}/rings/new">Ring Creator (Powerful Ainur Only)</a></h3>
				<h3><a href="/admin/${user.id}/guilds/new">Person/Team Creator (Powerful Ainur only)</a></h3>		
			</c:when>
					
			<c:otherwise>
				<h3><a href="/dashboard">Ring Creator (Powerful Ainur Only)</a></h3>
				<h3><a href="/dashboard">Person/Team Creator (Powerful Ainur only)</a></h3>				
				
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>Rings you have found</th>
						<th>Action</th>
					</tr>
					
					<c:forEach items="${user.rings}" var="ring">
						<tr>
							<td><c:out value="${ring.getName()}"/></td>
							<td><a href="/user/${user.id}/rings/${ring.id}/delete">Lose The Ring (Delete)</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>