package org.sunbeam.lib.mgmt.app.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sunbeam.lib.mgmt.app.dboperations.ConnectionProvider;
import org.sunbeam.lib.mgmt.app.obj.User;

public class UserService {

	String slectQuery = "SELECT id, name, email, phone, role, passwd from users where email = ";
	
	public User login(String email, String password) throws Exception {
		
		
		
		User user = findUserBasedonEmailId(email);
		
		validateLogin(password, user);
		return user;
	    
	}

	private User findUserBasedonEmailId(String email) throws Exception, SQLException {
		Connection con = ConnectionProvider.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(slectQuery.concat("'"+ email + "';"));
		
		User user = null ;
		
		while(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNumber(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			user.setPassword(rs.getString("passwd"));
		}
		return user;
	}

	public User librarianAppointment(String emailId, boolean appointUnappointFlag) throws Exception {
		
		User user = findUserBasedonEmailId(emailId);
		
		if(appointUnappointFlag) {
			//appointing new librarian
			user.setRole("LIBRARIAN");
		} else {
			//unappoint librarian
			user.setRole("USER");
		}
		
		updateUser(user);
		
		return user;
	}
	
	
	public List<User> findAllUsers() throws Exception {
		String slectQuery = "SELECT id, name, email, phone, role from users ;";
		
		Connection con = ConnectionProvider.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(slectQuery);
		
		List<User> users = new ArrayList<User>();
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNumber(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			users.add(user);
		}
		
		return users;
	}
	
	public void updateUser(User user) throws Exception {
		
		String updateQuery = "UPDATE USERS "
				+ "SET name = '" + user.getName() + "'," 
				+ " passwd = '" + user.getPassword() + "',"
				+ " role = '" + user.getRole() + "',"
				+ " phone = '" + user.getPhoneNumber() +"'"
				+ " WHERE id = " + user.getId() + ";";
		System.out.println("Running "+ updateQuery);		
		Connection con = ConnectionProvider.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(updateQuery);
		con.commit();
		
	}
	
	public void deleteUser(String emailId) throws Exception {
		Connection con = ConnectionProvider.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM USERS WHERE email = '"+ emailId+"';");
	}
	
	private void validateLogin(String password, User user) throws Exception {
		if(user == null) {
			throw new Exception("This email id does not exists.. please check email again.. if new User Signup first");
		} else if(!(user.getPassword().equals(password))) {
			throw new Exception("Password is wrong.. please try with correct password");
		}
	}
}
