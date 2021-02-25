<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Car Page</title>

</head>
<body>
	<form action = "editCarServlet" method="post">
	Year: <input type="text" name="year" value="${carToEdit.year }">
	Make: <input type="text" name="make" value="${carToEdit.make }">
	Model: <input type="text" name="model" value="${carToEdit.model }">
	<!-- The hidden field lets me have a field without the user getting to modify it -->
	<input type = "hidden" name ="id" value="${carToEdit.id }">
	<input type = "submit" value="Save Edited Car">
	</form>
</body>
</html>