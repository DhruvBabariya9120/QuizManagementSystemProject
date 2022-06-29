
package com.quizmanagementsystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.dao.UserDao;

/**
 * Developer : Dhruv Objective : Date : Jun 16, 2022 Time : 2:09:01 PM
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int registerUserDetails(Connection connection, User user) throws SQLException {

	int ans = 0;
	String insertQuery = "insert into user(user_fullname, email, contactno, password, gender, role, status) values(?,?,?,?,?,?,?)";
	try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
	    ps.setString(1, user.getName());
	    ps.setString(2, user.getEmail());
	    ps.setString(3, user.getContactno());
	    ps.setString(4, user.getPassword());
	    ps.setString(5, user.getGender());
	    ps.setString(6, user.getRole());
	    ps.setInt(7, user.getStatus());
	    ans = ps.executeUpdate();
	}
	return ans;
    }

    @Override
    public int validateEmail(Connection connection, String email) throws SQLException {
	int ans = 0;
	try (PreparedStatement ps = connection.prepareStatement("select * from user");
		ResultSet resultset = ps.executeQuery()) {
	    while (resultset.next()) {
		if (email.equals(resultset.getString("email")) && resultset.getInt("status") == 1) {
		    ans = 1;
		    break;
		}
	    }

	}
	return ans;
    }

    @Override
    public User checkLoginDetails(Connection connection, String email, String encryptpassword) throws SQLException {
	User user = new User();
	try (PreparedStatement ps = connection.prepareStatement("select * from user");
		ResultSet resultset = ps.executeQuery()) {
	    while (resultset.next()) {
		if (email.equals(resultset.getString("email"))
			&& encryptpassword.equals(resultset.getString("password")) && resultset.getInt("status") == 1) {
		    user.setId(resultset.getInt(1));
		    user.setName(resultset.getString("user_fullname"));
		    user.setEmail(resultset.getString("email"));
		    user.setContactno(resultset.getString("contactno"));
		    user.setGender(resultset.getString("gender"));
		    user.setPassword(resultset.getString("password"));
		    user.setRole(resultset.getString("role"));
		    user.setStatus(resultset.getInt("status"));
		    break;
		}
	    }
	}
	return user;
    }

    @Override
    public List<User> selectUserDetails(Connection connection) throws SQLException {
	List<User> user1 = new ArrayList<>();
	try (PreparedStatement ps = connection.prepareStatement("select * from user")) {
	    ResultSet resultset = ps.executeQuery();
	    while (resultset.next()) {
		User user = new User();
		user.setId(resultset.getInt(1));
		user.setName(resultset.getString("user_fullname"));
		user.setEmail(resultset.getString("email"));
		user.setContactno(resultset.getString("contactno"));
		user.setGender(resultset.getString("gender"));
		user.setPassword(resultset.getString("password"));
		user.setRole(resultset.getString("role"));
		user.setStatus(resultset.getInt("status"));
		user1.add(user);
	    }
	}
	return user1;
    }
}
