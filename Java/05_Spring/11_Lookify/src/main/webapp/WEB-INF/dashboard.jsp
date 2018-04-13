<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
	<c:forEach items="${errs}" var="err">
		<h2><c:out value="${err.getDefaultMessage()}"/></h2>
	</c:forEach>

	<div>
		<h3><a href="/songs/new">Add New</a></h3>
		<h3><a href="/songs/top10">Top Songs</a></h3>
		
		<form method="post" action="/search">
			<input type="text" name="artist"></input>
			<input type="submit" value="Search Artists"></input>
		</form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>Name</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${songs}" var="song" varStatus="loop" >
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
					<td><c:out value="${song.artist}" /></td>
					<td><c:out value="${song.rating}" /></td>
					<td> <a href="/songs/delete/${song.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</html>