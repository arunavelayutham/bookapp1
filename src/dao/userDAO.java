package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import model.Book;
import model.users;

public class userDAO {
	private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void addbook(users user) throws Exception {

		Connection con = ConnectionUtil.getConnection();

		String sql = "insert into users ( name, emailid,password ) values ( ?, ? ,? )";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmailid());
		pst.setString(3, user.getPassword());
		int rows = jdbcTemplate.update(user.getName(), user.getEmailid(), user.getPassword());

		System.out.println("no of rows inserted:" + rows);
	}

	public List<users> login(String email, String password) throws Exception {
		String sql = "select id,name,emailid,password from users where emailid = ? and password = ? ";

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, email);
		pst.setString(2, password);
		List<users> userList = jdbcTemplate.query(sql, (rs, rowNum) -> {

			int id = rs.getInt("id");
			String name = rs.getString("name");
			String emailid = rs.getString("emailid");
			String password1 = rs.getString("password");

			users user = new users();
			user.setId(id);
			user.setName(name);
			user.setEmailid(emailid);
			user.setPassword(password1);
			System.out.println(user);
			return user;
		});
		return userList;

	}

}
