<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>

	<head>
		<title>Show</title>
	</head>
	
	<body>
		<h2><a href="/dashboard">Dashboard</a></h2>
	
		<h2>Name: <c:out value="${song.name}" />   </h2>
		<h2>Artist: <c:out value="${song.artist}" /> </h2>
		<h2>Rating: <c:out value="${song.rating}" /></h2> 		
		<h2><a href="/songs/delete/${song.id}">Delete</a></h2>
	</body>
</html>