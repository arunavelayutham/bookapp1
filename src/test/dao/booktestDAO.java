package test.dao;
import dao.userDAO;
import model.users;

public class booktestDAO {
	
	public static void main(String[] args) throws Exception {
		 
        users user = new users();
        user.setName("pri");
        user.setEmailid("priyanka@gmail.com");
        user.setPassword("pass123");
 
        userDAO userDAO = new userDAO();
        userDAO.addbook(user);
 
	}
 
}



