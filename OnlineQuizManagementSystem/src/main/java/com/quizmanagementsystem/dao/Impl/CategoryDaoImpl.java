/**
 * 
 */
package com.quizmanagementsystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.dao.CategoryDao;

/**
 * Developer : Dhruv Objective : Date : Jun 18, 2022 Time : 6:07:03 PM
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public int insertCategoryDetails(Connection connection, Category category) throws SQLException {
	int result = 0;
	try (PreparedStatement ps = connection.prepareStatement("insert into category(category_name) values(?)")) {
	    ps.setString(1, category.getName());
	    result = ps.executeUpdate();
	}
	return result;
    }

    @Override
    public List<Category> fatchCategory(Connection connection) throws SQLException {
	List<Category> category = new ArrayList<>();
	try (PreparedStatement ps = connection.prepareStatement("select * from category");
		ResultSet resultset = ps.executeQuery()) {
	    while (resultset.next()) {
		Category cat = new Category();
		cat.setCat_id(resultset.getInt(1));
		cat.setName(resultset.getString(2));
		cat.setStatus(resultset.getInt(3));
		category.add(cat);
	    }
	}
	return category;
    }

    @Override
    public Category findCategoryDetails(Connection connection, String cat_Id) throws SQLException {
	Category category = new Category();
	try (PreparedStatement ps = connection.prepareStatement("select * from category where category_id=?")) {
	    ps.setString(1, cat_Id);

	    ResultSet resultset = ps.executeQuery();

	    while (resultset.next()) {
		category.setCat_id(resultset.getInt(1));
		category.setName(resultset.getString(2));
	    }
	}
	return category;
    }

    @Override
    public int updateCategory(Connection connection, Category category) throws SQLException {
	int ans = 0;
	String updateQuery = "update category set category_name=? where category_id= ? ";
	try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {

	    ps.setString(1, category.getName());
	    ps.setInt(2, category.getCat_id());

	    ans = ps.executeUpdate();
	}
	return ans;
    }

    @Override
    public int modifyCategoryStatus(Connection connection, String id) throws SQLException {
	int ans = 0;
	int status = 0;
	try (PreparedStatement ps = connection.prepareStatement("select * from category where category_id= ?")) {

	    ps.setInt(1, Integer.parseInt(id));
	    try (ResultSet resultset = ps.executeQuery()) {
		while (resultset.next()) {
		    status = resultset.getInt("status");
		}
	    }
	}
	if (status == 0) {
	    status = 1;
	} else {
	    status = 0;
	}
	try (PreparedStatement ps1 = connection.prepareStatement("update category set status=? where category_id=?")) {
	    ps1.setInt(1, status);
	    ps1.setInt(2, Integer.parseInt(id));
	    ans = ps1.executeUpdate();
	}
	try (PreparedStatement ps2 = connection
		.prepareStatement("update question_answer set status=? where category_id=?")) {
	    ps2.setInt(1, status);
	    ps2.setInt(2, Integer.parseInt(id));

	    ans = ps2.executeUpdate();
	}
	return ans;
    }

}
