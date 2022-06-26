/**
 * 
 */
package com.quizmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.quizmanagementsystem.bean.Category;

/**
 * Developer : Dhruv Objective : Date : Jun 18, 2022 Time : 6:06:13 PM
 */
public interface CategoryDao {

    /**
     * @param connection
     * @param category
     * @return
     */
    int insertCategoryDetails(Connection connection, Category category) throws SQLException;

    /**
     * @param connection
     * @return
     */
    List<Category> fatchCategory(Connection connection) throws SQLException;

    /**
     * @param connection
     * @param cat_Id
     * @return
     */
    Category findCategoryDetails(Connection connection, String cat_Id) throws SQLException;

    /**
     * @param connection
     * @param category
     * @return
     */
    int updateCategory(Connection connection, Category category) throws SQLException;

}
