package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bookDAO;
import dao.userDAO;
import model.Book;
import model.users;


@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("AddBookServlet");
		
		String name =request.getParameter("name");
		String price =request.getParameter("price");
		String published_date =request.getParameter("published_date");
		String author_id =request.getParameter("author_id");
		
		out.println("Name="+ name);
		out.println("price="+ price);
		out.println("published_date="+ published_date);
		out.println("author_id="+author_id);
		int price1 = Integer.parseInt(price);
LocalDate published_date1 =LocalDate.parse(published_date);
int author_id1 =Integer.parseInt(author_id);

		bookDAO bookDAO =new bookDAO();
		
		Book book = new Book();

		book.setName(name);
		book.setPrice(price1);
		book.setPub_date(published_date1);
		book.setAuthor_id(author_id1);
          out.println(book);
          try {
  			bookDAO.register(book);
  			
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
            response.sendRedirect("addbook.jsp");
	}
}

	