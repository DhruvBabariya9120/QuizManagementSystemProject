
package com.quizmanagementsystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
