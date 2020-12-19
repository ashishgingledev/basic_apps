package org.sunbeam.lib.mgmt.app;

import org.sunbeam.lib.mgmt.app.menu.LibrarianMenu;
import org.sunbeam.lib.mgmt.app.menu.LoginSignupMenu;
import org.sunbeam.lib.mgmt.app.menu.OwnerMenu;
import org.sunbeam.lib.mgmt.app.menu.UserMenu;
import org.sunbeam.lib.mgmt.app.obj.User;

/**
 * @author Vaishnvi Gawande
 * 
 *         Starting Point of the application
 */
public class LibraryManagementApplication {

	public static void main(String[] args) throws Exception {

		LoginSignupMenu commonMenu = new LoginSignupMenu();
		OwnerMenu ownerMenu = new OwnerMenu();
		UserMenu usermenu = new UserMenu();
		LibrarianMenu libMenu = new LibrarianMenu();
		User user = commonMenu.loginMenu();
        
		
		switch (user.getRole()) {
		case "OWNER":
			System.out.println("Welcome " + user.getName() + " Your role is OWNER");
			ownerMenu.showOwnerMenu(user);
			break;
		case "USER":
			
			break;
		case "LIBRARIAN":
			System.out.println("Welcome " + user.getName() + " Your role is LIBRARIAN");
			break;
		
		default:
			System.out.println("Unknown ");
			break;
		}
	}

}
