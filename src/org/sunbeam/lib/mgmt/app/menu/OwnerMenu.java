package org.sunbeam.lib.mgmt.app.menu;

import java.util.Scanner;

import org.sunbeam.lib.mgmt.app.obj.User;
import org.sunbeam.lib.mgmt.app.service.UserService;

public class OwnerMenu {

	private static final Scanner scanner = new Scanner(System.in);

	private UserService userService = new UserService();
	
	public void showOwnerMenu(User user) throws Exception {

		System.out.println("Please choose option to perform operations");
		System.out.println("1. Find all users");
		System.out.println("2. Appoint Librarian");
		System.out.println("3. Unappoint Librarian");
		System.out.println("4. Remove User");

		int option = scanner.nextInt();

		switch (option) {
		case 1:

			System.out.println(userService.findAllUsers());
			break;
		case 2:
			System.out.println("Please provide email id of User who you want to appoint as Librarian");
			userService.librarianAppointment(scanner.next(), true);
			break;
		case 3:
			System.out.println("Please provide email id of User who you want to unappoint from Librarian to user");
			userService.librarianAppointment(scanner.next(), false);
			break;
		case 4:
			System.out.println("Please provide email id of User who you want remove from system");
			userService.deleteUser(scanner.next());
			break;
		default:
			break;
		}

	}
}
