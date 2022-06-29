
package com.quizmanagementsystem.service;

import java.util.List;

import com.quizmanagementsystem.bean.User;

/**
 * Developer : Dhruv Objective : Date : Jun 16, 2022 Time : 2:10:08 PM
 */
public interface UserService {

    public String saveUserDetails(User user);

    public int Checkemaildetails(String email);

    public User verifyLoginDetails(String email, String encryptpassword);

    public List<User> selectUserDetails();
}
