
package com.quizmanagementsystem.service;

import com.quizmanagementsystem.bean.User;

/**
 * Developer : Dhruv Objective : Date : Jun 16, 2022 Time : 2:10:08 PM
 */
public interface UserService {

    public String saveUserDetails(User user);

    public int Checkemaildetails(String email);

    public User verifyLoginDetails(String email, String encryptpassword);
}
