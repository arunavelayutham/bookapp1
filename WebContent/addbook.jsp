
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add Books</title>

</head>
<body>

<h3>Add Books</h3>

<form action="AddBookServlet">

Book Name:<input type="text"name="name" required autofocus /><br/>
Price:<input type="number"name="price"required/><br/>
Published Date:<input type="date"name="published_date"required/><br/>
Author id:<input type="id"name="author_id"required/><br/>
<button type="submit"> Submit</button>

</form>
</body>

