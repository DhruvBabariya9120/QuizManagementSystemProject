
package com.quizmanagementsystem.bean;

public class User {

    private String name;
    private String email;
    private String contactno;
    private String gender;
    private String password;
    private String role;
    private int status;

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the contactno
     */
    public String getContactno() {
	return contactno;
    }

    /**
     * @param contactno the contactno to set
     */
    public void setContactno(String contactno) {
	this.contactno = contactno;
    }

    /**
     * @return the gender
     */
    public String getGender() {
	return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * @return the role
     */
    public String getRole() {
	return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
	this.role = role;
    }

    /**
     * @return the status
     */
    public int getStatus() {
	return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return "User [name=" + name + ", email=" + email + ", contactno=" + contactno + ", gender=" + gender
		+ ", password=" + password + ", role=" + role + ", status=" + status + "]";
    }

}
