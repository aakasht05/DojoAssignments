<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
	<c:forEach items="${errs}" var="err">
		<h2><c:out value="${err.getDefaultMessage()}"/></h2>
	</c:forEach>

	<form:form action="/songs/new" method="post" modelAttribute="song">
		<form:label path="name">Name:
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>
		</form:label>	

		<form:label path="artist">Artist:
			<form:input path="artist"></form:input>
			<form:errors path="artist"></form:errors>
		</form:label>	

		<form:label path="rating">Rating:
			<form:select path="rating">
				<form:option value="1" />
				<form:option value="2" />
				<form:option value="3" />
				<form:option value="4" />
				<form:option value="5" />
				<form:option value="6" />
				<form:option value="7" />
				<form:option value="8" />
				<form:option value="9" />
				<form:option value="10" />
			</form:select>
			<form:errors path="rating"></form:errors>
		</form:label>	

		<input type="submit" value="Add Song"></input>
	</form:form>
</html>