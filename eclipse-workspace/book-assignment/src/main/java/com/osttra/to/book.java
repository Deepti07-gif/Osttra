package com.osttra.to;

public class book {

	private String bookName;
	private String authorName;
	private String bookDescription;
	private String bookID;

	public book() {
		super();
	}

	public book(String bookName, String authorName, String bookDescription, String bookID) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookDescription = bookDescription;
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

}
