
package com.quizmanagementsystem.service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.dao.UserDao;
import com.quizmanagementsystem.dao.Impl.UserDaoImpl;
import com.quizmanagementsystem.service.UserService;

/**
 * Developer : Dhruv Objective : Date : Jun 16, 2022 Time : 2:11:43 PM
 */
public class UserServiceImpl implements UserService {

    UserDao userdao = new UserDaoImpl();

    public Connection getConnection() {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {

	    e.printStackTrace();
	}

	try {
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizmanagementsystem",
		    "root", "root");
	    return connection;
	} catch (SQLException e) {

	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public String saveUserDetails(User user) {
	String ans = "";
	try (Connection connection = getConnection()) {

	    int value = userdao.registerUserDetails(connection, user);

	    if (value > 0) {
		ans = "User Register Successfully";
	    } else {
		ans = "User Not Register Successfully";
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return ans;
    }

    @Override
    public int Checkemaildetails(String email) {
	int ans = 0;
	try (Connection connection = getConnection()) {
	    ans = userdao.validateEmail(connection, email);

	} catch (SQLException e) {

	    e.printStackTrace();
	}
	return ans;
    }

    @Override
    public User verifyLoginDetails(String email, String encryptpassword) {
	User user = null;
	try (Connection connection = getConnection()) {

	    user = userdao.checkLoginDetails(connection, email, encryptpassword);

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return user;
    }

    @Override
    public List<User> selectUserDetails() {
	List<User> user = new ArrayList<>();
	try (Connection connection = getConnection()) {

	    user = userdao.selectUserDetails(connection);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return user;
    }

}
