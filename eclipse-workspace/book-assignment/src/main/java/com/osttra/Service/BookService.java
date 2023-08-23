package com.osttra.Service;

import java.util.Scanner;


import com.osttra.dao.BookDAO;
import com.osttra.to.book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	BookDAO bookDAO = new BookDAO();
	

	public void addBook() {
		System.out.println("Please Enter book details" );
		
		System.out.println("Book Name:");
		String bookName = sc.next();
		
		System.out.println("Author's Name:");
		String authorName = sc.next();
		
		System.out.println("Book Description:");
		String bookDescription = sc.next();
		System.out.println("Book ID:");
		String bookID = sc.next();

		book book = new book(bookName, authorName, bookDescription, bookID);
		bookDAO.addBookDB(book);
	}

	public void deleteBook() {
		System.out.println("Enter Book ID you want to delete !");
		String bookDelete = sc.next();

		bookDAO.deleteBook(bookDelete);
	}

	public void searchBook() {
		System.out.println("Enter Book ID you want to search !\n");
		String bookSearch = sc.next();

		book bookDetail = bookDAO.searchBook(bookSearch);

		System.out.println("\tBook Details\n");
		System.out.println("Book Name:" + bookDetail.getBookName());
		System.out.println("Author Name:" + bookDetail.getAuthorName());
		System.out.println("Book Description:" + bookDetail.getBookDescription());
		System.out.println("Book ID:" + bookDetail.getBookID() + "\n" + "\n");
	}

	public void getAllBook() {
		System.out.println("All Books are peresent here !\n");
		bookDAO.displayAllBook();
	}
}
