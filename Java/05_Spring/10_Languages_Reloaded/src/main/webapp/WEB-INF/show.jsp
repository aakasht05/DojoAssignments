<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Show Language</title>
	</head>
	
	<body>	
		<h1> <c:out value="${language.name}"/> </h1>
		<h1> <c:out value="${language.creator}"/> </h1>
		<h1> <c:out value="${language.version}"/> </h1>
		<h1><a href="/languages/edit/${language.id}">Edit</a></h1>
		<h1><a href="/languages/delete/${language.id}">Delete</a></h1>
	</body>
</html>