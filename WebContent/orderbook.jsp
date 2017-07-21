<%@page import="model.users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Book</title>
</head>
<body>

<%
users user = (users) session.getAttribute("Logged_In_User");
%>
<form action="OrderBookServlet">
Userid:<input type = "number" name ="userid" value="<%=user.getId() %>" readonly required /><br/>
select Book:
<select name="bookid"required>
<option value="1">Core Java</option>
<option value="2">MySQL</option>
</select>
<br/>
Quantity:<input type="number" name="quantity" min="1" required/>
<br/>

<button type="submit">Submit</button>
</form>
</body>
</html>