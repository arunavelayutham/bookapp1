package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import model.Book;

public class bookDAO {
	 private static JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public void register(Book user) throws Exception {


		String sql = "insert into books( name, price, pub_date,author_id) values ( ?, ? ,? ,?)";


		int rows = jdbcTemplate.update(sql,user.getName(),user.getPrice(),user.getPub_date(),user.getAuthor_id());	
		System.out.println("no of rows inserted:" + rows);

	}

	public List<Book> listbook() throws Exception {
		String sql = "select id, name ,price,pub_date,author_id from books";
		List<Book> bookList = jdbcTemplate.query(sql, (rs, rowNum) -> {	

		
			int id = rs.getInt("id");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			Date pub_date = rs.getDate("pub_date");
			int author_id = rs.getInt("author_id");
			Book b = new Book();
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setPub_date(pub_date.toLocalDate());
			b.setAuthor_id(author_id);

			
			return b;
		});
		return bookList;
	}

}