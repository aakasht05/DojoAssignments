<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="css/style.css" rel="stylesheet"></link>
</head>
<body>
	<c:out value="${err}" />
	
	<h2>What is the code?</h2>
	<form action="/process" method="post">
		<input name="code" type="text"></input>
		<input type="submit"></input>
	</form>
</body>
</html>
