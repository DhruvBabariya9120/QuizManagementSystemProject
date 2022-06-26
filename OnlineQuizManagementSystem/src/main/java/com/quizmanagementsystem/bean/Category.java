/**
 * 
 */
package com.quizmanagementsystem.bean;

/**
 * Developer : Dhruv Objective : Date : Jun 18, 2022 Time : 5:39:18 PM
 */
public class Category {

    private int cat_id;
    private String name;
    private int status;

    /**
     * @return the cat_id
     */
    public int getCat_id() {
	return cat_id;
    }

    /**
     * @param cat_id the cat_id to set
     */
    public void setCat_id(int cat_id) {
	this.cat_id = cat_id;
    }

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
	return "Category [cat_id=" + cat_id + ", name=" + name + ", status=" + status + "]";
    }

}
