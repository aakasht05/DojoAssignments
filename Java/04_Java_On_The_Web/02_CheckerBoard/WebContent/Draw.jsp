<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css" type="text/css" media="screen, projection">
	</head>

	<body>
        <div class="content">
            <h1>CheckerBoard: <%=request.getParameter("width")%>w X <%=request.getParameter("height")%>h</h1>

            <% int w = Integer.parseInt(request.getParameter("width")); %>
            <% int h = Integer.parseInt(request.getParameter("height")); %>
            
            <% for(int y=0;y<h;y++){ %>
                <% for(int x=0;x<w;x++){ %>
                    <% if(x%2 == 0){ %>
                        <div class="red"></div>
                    <% } else{ %>
                        <div class="blue"></div>
                    <% } %>
                <% } %>
            <% } %>
        </div>
	</body>
</html>