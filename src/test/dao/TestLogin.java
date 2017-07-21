package test.dao;

import dao.userDAO;
import model.users;

public class TestLogin {

	
	public static void main(String[] args) throws Exception {
		 
        users user = new users();
        user.setName("aruna");
        user.setEmailid("vjaarthi07@gmail.com");
        user.setPassword("aruna20");
        
        
 String emailid ="vjaarthi07@gmail.com";
 String password1 ="aruna20";
 
        userDAO userDAO = new userDAO();
       users u= userDAO.login(emailid,password1);
        System.out.println(u);
}
	
}