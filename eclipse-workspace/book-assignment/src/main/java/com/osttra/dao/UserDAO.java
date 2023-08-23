package com.osttra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.osttra.to.*;
import com.osttra.utils.DBUtils;

public class UserDAO {

	Connection dbConnection = DBUtils.getConnection();
	PreparedStatement statement;

	public void addUser(User user) {

		try {
			statement = dbConnection.prepareStatement("insert into user_details values(?,?,?,?,?,?)");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getUserType());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.executeUpdate();
			System.out.println("------ New user registered!!! -----" + "\n\n");
		} catch (SQLException e) {
			System.out.println( "----- Username already exist!!! -----" + "\n\n");
		}
	}

	public User getUser(User user) {
		User isUser = null;
		try {
			statement = dbConnection.prepareStatement("select * from user_details where username = ? and password = ?");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {

				String firstName = resultSet.getString(1);
				String lastName = resultSet.getString(2);
				String email = resultSet.getString(3);
				String userType = resultSet.getString(4);
				String username = resultSet.getString(5);
				String password = resultSet.getString(6);

				isUser = new User(firstName, lastName, email, userType, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUser;
	}

	public void deleteUser(String userDelete) {
		PreparedStatement statement = null;
		try {

			statement = dbConnection.prepareStatement("delete from user_details where username = ?");
			statement.setString(1, userDelete);

			int resultSet = statement.executeUpdate();

			if (resultSet != 0) {
				System.out.println("User deleted successfully!\n\n");
			} else {
				System.out.println("User not found or could not be deleted!\n\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}