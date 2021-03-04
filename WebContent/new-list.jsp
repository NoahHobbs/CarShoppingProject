<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New list</title>
</head>
<body>
<form action="createNewListServlet" method="post">
List Name: <input type = "text" name ="listName"><br />
Owner Name: <input type = "text" name="ownerName"><br />
Available Cars: <br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value = "${currentitem.id }">${currentitem.year} | 
	${currentitem.make} | ${currentitem.model }</option>
</c:forEach>
</select>
<br />
<input type = "submit" value ="Create list and add items">
</form>
<a href="index.html"> Go add new items instead</a>
</body>
</html>