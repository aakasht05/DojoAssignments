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
	<title>Beginning Of Kek</title>
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
			<input id="back" class="btn btn-link" type="submit" value="Back" />
		</form>
	
		<h1 class="center">Welcome, <c:out value="${user.username}" /></h1>
		
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Guilds</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${users}" var="userInner">
				<c:choose>
					<c:when test="${!userInner.isAdmin()}">
						<tr>
							<td><c:out value="${userInner.username}" /></td>
							
							<td>
								<c:forEach items="${userInner.guilds}" var="guild">
									<a href="/admin/${user.id}/guilds/${guild.id}"><c:out value="${guild.name}"/></a>
								</c:forEach>					
							</td>
		
							<!-- Are we getting the time the user was created? Or the time they we're added to a guild? Or each guilds individual created at time? Not sure. -->
							<td><c:out value="${Math.floor((curTime - userInner.createdAt.getTime()) / (1000*60*60*24))} day(s)"/></td>
		
							<td><a href="/admin/${user.id}/delete/${userInner.id}">Delete</a> | <a href="/admin/promote/${userInner.id}">Promote</a></td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</table>
		
		<form name="userForm" class="form-horizontal left" action="/admin/${user.id}/guilds/add" method="post">
		    <c:if test="${hasGuild != null}">
				<div class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<c:out value="${hasGuild}"></c:out>
				</div>	
		    </c:if>	
		    <c:if test="${userErr != null}">
				<div class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<c:out value="${userErr}"></c:out>
				</div>	
		    </c:if>	
		    <c:if test="${guildErr != null}">
				<div class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<c:out value="${guildErr}"></c:out>
				</div>	
		    </c:if>	
		    <c:if test="${guildFull != null}">
				<div class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<c:out value="${guildFull}"></c:out>
				</div>	
		    </c:if>	

			<div class="form-group">
				<label for="user" class="control-label col-sm-2">Name:</label>
				
				<div class="col-sm-10">
					<select class="form-control" id="user" name="user">
						<c:forEach items="${users}" var="user">
							<c:choose>
								<c:when test="${!user.isAdmin()}">
									<option value="${user.id}"><c:out value="${user.username}"/></option>
								</c:when>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="guild" class="control-label col-sm-2">Guild:</label>
				
				<div class="col-sm-10">
					<select class="form-control" id="guild" name="guild">
						<c:forEach items="${guilds}" var="guild">
							<option value="${guild.id}"><c:out value="${guild.name}"/></option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">        
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Join</button>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>

		<form:form name="guildForm" class="form-horizontal right" action="/admin/${user.id}/guilds/new" method="post" modelAttribute="guild">
			<spring:hasBindErrors name="guild">
				<c:forEach items="${errors.allErrors}" var="error">
					<div class="alert alert-danger alert-dismissable">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
						<spring:message message="${error}"></spring:message>
					</div>					
				</c:forEach>
			</spring:hasBindErrors>

			<div class="form-group">
				<form:label class="control-label col-sm-2" path="name">Guild Name:</form:label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" id="name" placeholder="Enter Guild Name" path="name"></form:input>
				</div>
			</div>

			<div class="form-group">
				<form:label class="control-label col-sm-2" path="size">Guild Size:</form:label>
				<div class="col-sm-10">
					<form:input type="number" class="form-control" id="size" placeholder="Enter Guild Size" path="size"></form:input>
				</div>
			</div>

			<div class="form-group">        
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Create</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>