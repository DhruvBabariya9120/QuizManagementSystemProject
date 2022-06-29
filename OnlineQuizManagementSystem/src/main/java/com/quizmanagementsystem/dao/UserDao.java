
package com.quizmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.quizmanagementsystem.bean.User;

/**
 * Developer : Dhruv Objective : Date : Jun 16, 2022 Time : 2:08:18 PM
 */
public interface UserDao {

    public int registerUserDetails(Connection connection, User user) throws SQLException;

    public int validateEmail(Connection connection, String email) throws SQLException;

    public User checkLoginDetails(Connection connection, String email, String encryptpassword) throws SQLException;

    public List<User> selectUserDetails(Connection connection) throws SQLException;
}
