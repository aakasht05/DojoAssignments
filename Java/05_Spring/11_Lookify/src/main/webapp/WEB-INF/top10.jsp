<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
	<c:forEach items="${errs}" var="err">
		<h2><c:out value="${err.getDefaultMessage()}"/></h2>
	</c:forEach>

	<h2> <a href="/dashboard">Dashboard</a></h2>
	<h2>Top Ten Songs:</h2>
	
	<c:forEach items="${songs}" var="song" varStatus="loop">
		<h3> <c:out value="${song.rating}" /> - <a href="/songs/${song.id}"><c:out value="${song.name}"/></a> - <c:out value="${song.artist}"/> </h3>
	</c:forEach>
</html>