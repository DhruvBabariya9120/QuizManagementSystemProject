
package com.quizmanagementsystem.service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	try {
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizmanagementsystem",
		    "root", "root");
	    return connection;
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
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

}
