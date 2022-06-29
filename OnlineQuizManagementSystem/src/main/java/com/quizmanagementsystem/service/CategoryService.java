/**
 * 
 */
package com.quizmanagementsystem.service;

import java.util.List;

import com.quizmanagementsystem.bean.Category;

/**
 * Developer : Dhruv Objective : Date : Jun 18, 2022 Time : 6:07:22 PM
 */
public interface CategoryService {

    String saveCategoryDetails(Category category);

    List<Category> selectCategoryDetails();

    Category fetchCategoryDetails(String cat_Id);

    int modifyCategoryDetails(Category category);

    int changeCategoryStatus(String id);

}
