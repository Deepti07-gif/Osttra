package com.osttra;

import java.util.Scanner;

import com.osttra.Service.UserService;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mainMenuChoice = 0;
		do {
			System.out.println("Welcome!!!\n\n" + "Please Enter Your choice:");
			System.out.println(" 1. Register \n" + " 2. Log In \n" + " 0. Exit");

			mainMenuChoice = sc.nextInt();

			UserService userService = new UserService();

			switch (mainMenuChoice) {
			case 1:
				userService.register();
				break;
			case 2:
				userService.logIn();
				break;
			case 0:
				System.out.println("\t Exit \n\n");
				break;
			default:
				System.out.println("Entered wrong number Please try again !!!\n\n");
				break;
			}
		} while (mainMenuChoice != 0);

		sc.close();
	}
}
