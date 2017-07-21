<!DOCTYPE html>

<%@page import="model.users"%>
<%@page import="model.Order"%>
<%@page import="dao.orderDAO"%>
<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@page import="dao.bookDAO"%>
<html>
<head>

<title>List books</title>
</head>
<body>
<%
users user = (users) session.getAttribute("Logged_In_User");
out.println("User:"+ user);
if (user == null ) {
	
	response.sendRedirect("login.html");
	
}
else
{
%>
Welcome<%=user.getName() %>  ( <a href="LogoutServlet" > Logout </a>)
<h3>list books</h3>
<table border ="1">
<tbody>
<%

bookDAO bookDAO =new bookDAO();
List<Book>bookList = bookDAO.listbook();
//out.println("Books:"+bookList);
%><table border="1">
	<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>price</th>
				<th>published_date</th>
				<th>AuthorName</th>
				
			</tr>
		</thead>	
		
	<%
		for (Book b : bookList) {
			out.println("<tr>");
			out.println("<td>" + b.getId() + "</td>");
			out.println("<td>" + b.getName() + "</td>");
			out.println("<td>" + b.getPrice() + "</td>");
			out.println("<td>" + b.getPub_date() + "</td>");
			out.println("<td>" + b.getAuthor_id() + "</td>");

			out.println("</tr>");
		}
	
	
	%>
		</tbody>
		</table>


</tbody>
</table>


<% }%>

<a href="orderbook.jsp"> Add Order</a>
</body>

</html>


