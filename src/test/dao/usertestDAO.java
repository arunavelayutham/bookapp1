package test.dao;

import java.time.LocalDate;

import dao.bookDAO;
import model.Book;

public class usertestDAO {
	
	public static void main(String[] args) throws Exception {
		 LocalDate L=LocalDate.parse("2017-06-08");
        Book user = new Book();
        user.setName("pri");
        user.setPrice(200);
        user.setPub_date(L);
        user.setAuthor_id(1);
        
        
 
        bookDAO userDAO = new bookDAO();
       // userDAO.register(user);
        userDAO.listbook();
  
	}
 
}



