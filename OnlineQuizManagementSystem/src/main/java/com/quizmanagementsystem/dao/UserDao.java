
package com.quizmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.quizmanagementsystem.bean.User;

/**
 * Developer : Dhruv Objective : Date : Jun 16, 2022 Time : 2:08:18 PM
 */
public interface UserDao {

    public int registerUserDetails(Connection connection, User user) throws SQLException;
}
