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
		
		<form:form method="post" action="/languages/update/${language.id}" modelAttribute="language">
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