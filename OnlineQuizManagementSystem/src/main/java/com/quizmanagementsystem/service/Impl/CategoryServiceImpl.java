/**
 * 
 */
package com.quizmanagementsystem.service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.dao.CategoryDao;
import com.quizmanagementsystem.dao.Impl.CategoryDaoImpl;
import com.quizmanagementsystem.service.CategoryService;

/**
 * Developer : Dhruv Objective : Date : Jun 18, 2022 Time : 6:08:03 PM
 */
public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

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
    public String saveCategoryDetails(Category category) {
	String str = "";
	try (Connection connection = getConnection()) {

	    int ans = categoryDao.insertCategoryDetails(connection, category);
	    if (ans > 0) {
		str = "Category Save Successful";
	    } else {
		str = "Category Not Save Successful";
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return str;
    }

    @Override
    public List<Category> selectCategoryDetails() {
	List<Category> category = new ArrayList<>();
	try (Connection connection = getConnection()) {

	    category = categoryDao.fatchCategory(connection);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return category;
    }

    @Override
    public Category fetchCategoryDetails(String cat_Id) {
	Category category = new Category();
	try (Connection connection = getConnection()) {
	    category = categoryDao.findCategoryDetails(connection, cat_Id);
	} catch (SQLException e) {

	    e.printStackTrace();
	}
	return category;
    }

    @Override
    public int modifyCategoryDetails(Category category) {
	int ans = 0;
	try (Connection connection = getConnection()) {
	    ans = categoryDao.updateCategory(connection, category);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return ans;

    }

}
