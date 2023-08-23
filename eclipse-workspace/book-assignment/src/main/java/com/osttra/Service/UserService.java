package com.osttra.Service;

import java.util.Scanner;

import com.osttra.dao.UserDAO;
import com.osttra.to.User;


public class UserService {
	Scanner sc = new Scanner(System.in);
	UserDAO userDAO = new UserDAO();

	public void getProfile(User isUser) {
		System.out.println("First Name:" + isUser.getFirstName());
		System.out.println("Last Name:" + isUser.getLastName());
		System.out.println("Email:" + isUser.getEmail());
		System.out.println("Username:" + isUser.getUsername() + "\n\n");
	}

	public void deleteUser() {
		System.out.println("Enter username of the user you want to delete !");
		String userDelete = sc.next();
		userDAO.deleteUser(userDelete);
	}

	

	BookService bookService = new BookService();

	public void register() {
		System.out.println("\n Register as new User!\n");
		
		System.out.println("First Name:");
		String firstName = sc.next();
		
		System.out.println("Last Name:");
		String lastName = sc.next();
		
		System.out.println("Email ID:");
		String email = sc.next();
		
		String userType = userTypeValidate();
		System.out.println("Username:");
		String username = sc.next();
		System.out.println("Password:");
		String password = sc.next();

		User user = new User(firstName, lastName, email, userType, username, password);
		userDAO.addUser(user);
	}

	public String userTypeValidate() {
		System.out.println("Role:");
		String typeOfUser = sc.next();
		if ("admin".equals(typeOfUser) || "user".equals(typeOfUser))
			;
		else {
			System.out.println("Invalid user type\n");
			userTypeValidate();
		}
		return typeOfUser;
	}


	public void logIn() {
		System.out.println("Enter your details to log in!\n");
		System.out.println("Username:");
		String username = sc.next();
		System.out.println("Password:");
		String password = sc.next();
		User user = new User(username, password);
		User isUser = userDAO.getUser(user);
		if (isUser != null) {

			System.out.println("\n Login successful !\n");

			String role = isUser.getUserType();

			if ("admin".equals(role)) {
				adminUser(isUser);
			} else {
				normalUser(isUser);
			}

		} else {

			System.out.println("Login failed! Invalid credentials.\n\n");
		}
	}

	public void normalUser(User isUser) {

		int userMenu = 0;
		do {
			System.out.println("\t Welcome User\n\n" + "Please Enter Your choice:");
			System.out.println(
					" 1.View Profile\n" + " 2.Search Book \n" + " 3.Show All Book \n" + " 0. Log Out");

			userMenu = sc.nextInt();

			switch (userMenu) {
			case 1:
				getProfile(isUser);
				break;
			case 2:
				bookService.searchBook();
				break;
			case 3:
				bookService.getAllBook();
				break;
			case 0:
				System.out.println("\n" + "----- Log Out Successfully!!! -----\n\n");
				break;
			default:
				System.out.println("----- Entered wrong number Please try again !!! -----\n\n");
				break;
			}
		} while (userMenu != 0);
	}

	public void adminUser(User isUser) {

		int userMenu = 0;
		do {
			System.out.println("\t Welcome Admin\n\n" + "Please Enter Your choice:");
			System.out.println(" 1.View Profile \n" + " 2.Add Book  \n" + " 3.Delete Book  \n"
					+ " 4.Search Book \n" + " 5.Delete User \n" + " 6.Show All book \n"
					+ " 0. Log Out");

			userMenu = sc.nextInt();

			switch (userMenu) {
			case 1:
				getProfile(isUser);
				break;
			case 2:
				bookService.addBook();
				break;
			case 3:
				bookService.deleteBook();
				break;
			case 4:
				bookService.searchBook();
				break;
			case 5:
				deleteUser();
				break;
			case 6:
				bookService.getAllBook();
				break;
			case 0:
				System.out.println("Log Out Successfully!\n\n");
				break;
			default:
				System.out.println(" Entered wrong number Please try again !-\n\n");
				break;
			}
		} while (userMenu != 0);

	}

}
