package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bookDAO;
import dao.orderDAO;
import model.Order;



@WebServlet("/OrderBookServlet")
public class OrderBookServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("OrderBookServlet");
		String userid =request.getParameter("userid");
		String bookid =request.getParameter("bookid");
		String quantity =request.getParameter("quantity");
		
		out.println("Userid="+ userid);
		out.println("Bookid="+ bookid);
		out.println("Quantity="+quantity);
		int userid1 = Integer.parseInt(userid);
		int bookid1 = Integer.parseInt(bookid);
		int quantity1 = Integer.parseInt(quantity);
		
		
        orderDAO orderDAO =new orderDAO();
		
		Order order = new Order();

		order.setUser_id(userid1);
		order.setBook_id(bookid1);
	    order.setQuantity(quantity1);
          out.println(order);
          try {
  			orderDAO.addorder(order);
  			
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
            response.sendRedirect("listorder.jsp");
		
}
}