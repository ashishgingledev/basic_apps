package org.sunbeam.lib.mgmt.app.menu;

import java.util.Scanner;

import org.sunbeam.lib.mgmt.app.obj.User;
import org.sunbeam.lib.mgmt.app.service.UserService;

public class LoginSignupMenu {

	private static final Scanner scanner = new Scanner(System.in);
	private UserService loginSignupService = new UserService();
	
	public User loginMenu() {
		System.out.println("1. ********WELCOME To Vaishnavi's Library, please choose any option as below******");
		System.out.println("1. LOGIN  : Please login with your email id and Password");
		System.out.println("2. SIGNUP : If yoru are new User, Please signup");
		System.out.println("3. Exit   : Exit from Program ");
		
		User user = null;
		int option = scanner.nextInt();
		
		switch (option) {
		case 1:
			System.out.println("Email Id");
			String emailId = scanner.next();
			System.out.println("Password");
			String password = scanner.next();
			try {
				user = loginSignupService.login(emailId, password);
				
				
			} catch (Exception e) {
				System.out.println("Error occurre while login attemp please try again " + e.getMessage());
			}
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			System.out.println("Incorrect option, please choose either 1 or 2");
			break;
		}
		
		return user;
	}
}
