package dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import model.Order;

public class orderDAO {
	 private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public void addorder(Order user) throws Exception {

		Connection con = ConnectionUtil.getConnection();

		String sql = "insert into orders(user_id,book_id,quantity) values ( ?, ?, ? )";

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, user.getUser_id());
		pst.setInt(2, user.getBook_id());
		pst.setInt(3, user.getQuantity());
		// pst.setString(4, user.getSatus());
		// pst.setDate(5,Date.valueOf(user.getOrdered_date()));

		int rows = jdbcTemplate.update(sql,user.getUser_id(),user.getBook_id(),user.getQuantity());
		System.out.println("no of rows inserted:" + rows);

	}

	public List<Order> listorderold() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id, user_id ,book_id,quantity,satus,ordered_date from orders";
		PreparedStatement pst = con.prepareStatement(sql);
		List<Order> orderList =jdbcTemplate.query(sql, (rs, rowNum) -> {	
			int id = rs.getInt("id");
			int user_id = rs.getInt("user_id");
			int book_id = rs.getInt("book_id");
			int quantity = rs.getInt("quantity");
			String satus = rs.getString("satus");
			Date ordered_date = rs.getDate("ordered_date");
			String username = rs.getString("username");
			String bookname =rs.getString("bookname");
			Order b = new Order();
			b.setId(id);
			b.setUser_id(user_id);
			b.setBook_id(book_id);
			b.setQuantity(quantity);
			b.setSatus(satus);
			b.setOrdered_date(ordered_date.toLocalDate());
			b.setUserName(username);
			b.setBookName(bookname);
	
		return  b;
		
	});
		return orderList;
	}

		public List<Order> listorder() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select o.id, user_id ,book_id,quantity,satus,ordered_date,u.name as username,b.name as bookname from orders o, users u,books b where u.id = o.user_id & o.book_id = b.id";
		PreparedStatement pst = con.prepareStatement(sql);
		
		List<Order>orderList = jdbcTemplate.query(sql, (rs, rowNum) -> {
		
			int id = rs.getInt("id");
			int user_id = rs.getInt("user_id");
			int book_id = rs.getInt("book_id");
			int quantity = rs.getInt("quantity");
			String satus = rs.getString("satus");
			Date ordered_date = rs.getDate("ordered_date");
			String username = rs.getString("username");
			String bookname =rs.getString("bookname");

			Order b = new Order();
			b.setId(id);
			b.setUser_id(user_id);
			b.setBook_id(book_id);
			b.setQuantity(quantity);
			b.setSatus(satus);
			b.setOrdered_date(ordered_date.toLocalDate());
			b.setUserName(username);
			b.setBookName(bookname);
			return b;
		});

		
		return orderList;
	}

}
