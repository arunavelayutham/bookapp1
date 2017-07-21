package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import model.users;

public class userDAO {
	private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void addbook(users user) throws Exception {

		String sql = "insert into users ( name, emailid,password ) values ( ?, ? ,? )";

		int rows = jdbcTemplate.update(user.getName(), user.getEmailid(), user.getPassword());

		System.out.println("no of rows inserted:" + rows);
	}

	public List<users> login(String email, String password) throws Exception {
		String sql = "select id,name,emailid,password from users where emailid = ? and password = ? ";

		Object[] params = { email, password };
		List<users> userList = jdbcTemplate.query(sql, params, (rs, rowNum) -> {

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
