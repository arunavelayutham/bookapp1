package model;

import java.time.LocalDate;

public class Order {
	private int id;
	private int user_id;
	private int book_id;
	private int quantity;
	private String satus;
	private LocalDate ordered_date;
	private String userName;
	private String bookName;
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSatus() {
		return satus;
	}

	public void setSatus(String satus) {
		this.satus = satus;
	}

	public LocalDate getOrdered_date() {
		return ordered_date;
	}

	public void setOrdered_date(LocalDate ordered_date) {
		this.ordered_date = ordered_date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", book_id=" + book_id + ", quantity=" + quantity
				+ ", satus=" + satus + ", ordered_date=" + ordered_date + ", userName=" + userName + ", bookName="
				+ bookName + "]";
	}


}
