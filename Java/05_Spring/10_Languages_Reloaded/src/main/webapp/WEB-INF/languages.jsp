<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Languages Reloaded</title>
	</head>
	
	<body>
		<c:forEach items="${errs}" var="err">
			<h1> <c:out value="${err.getDefaultMessage()}"/> </h1>	
		</c:forEach>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${languages}" var="language" varStatus="loop">
				<tr>
					<td><a href="/languages/show/${language.id}"> <c:out value="${language.name}"/> </a></td>
					<td><c:out value="${language.creator}"/></td>
					<td><c:out value="${language.version}"/></td>
					<td> <a href="/languages/edit/${language.id}">Edit</a> <a href="/languages/delete/${language.id}">Delete</a></td>
				</tr>
			</c:forEach>				
		</table>

		<form:form method="post" action="/languages/new" modelAttribute="language">
			<form:label path="name">
				<form:errors path="name"></form:errors>
				<form:input path="name"></form:input>
			</form:label>
			
			<form:label path="creator">
				<form:errors path="creator"></form:errors>
				<form:input path="creator"></form:input>
			</form:label>
			
			<form:label path="version">
				<form:errors path="version"></form:errors>
				<form:input path="version"></form:input>
			</form:label>
			
			<input type="submit"></input>
		</form:form>
	</body>
</html>