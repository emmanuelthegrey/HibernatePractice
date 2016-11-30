<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.aubrey.hibernate1.Book" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
</head>
<body>
<h1>Book List</h1>
<table border="1">
	<tr>
		<th>Rank</th>
		<th>Author</th>
		<th>Title</th>
		<th>Publisher/Imprint</th>
		<th>Sales</th>
	</tr>
<c:forEach items="${bookList }" var="book">
	<tr>
		<td>${book.rank }</td>
		<td>${book.author }</td>
		<td>${book.title }</td>
		<td>${book.publisher }: ${book.imprint }</td>
		<td>${book.sales }</td>
		<td><form action="delete" method="post">
  <input type="hidden" name="delete" value="${book.rank }">
  <input type="submit" value="Submit">
</form>
		
	</tr>
</c:forEach>
</table>
<form type="submit" action="home" method="get">
  <input type="submit" value="Home Page">
</form>
</body>
</html>