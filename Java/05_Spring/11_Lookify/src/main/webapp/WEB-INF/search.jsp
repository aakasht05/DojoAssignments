<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>

	<head>
		<title>Search</title>
	</head>
	
	<div>
		<h2><a href="/dashboard">Dashboard</a></h2>

		<form method="post" action="/search">
			<h2>Songs by artist: <c:out value="${songs.get(0).getArtist()}"/> </h2>
			<input type="text" name="artist" placeholder="${songs.get(0).getArtist()}"></input>
			<input type="submit" value="New Search"></input>
		</form>

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