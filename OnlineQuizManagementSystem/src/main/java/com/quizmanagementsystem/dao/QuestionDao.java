/**
 * 
 */
package com.quizmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.quizmanagementsystem.bean.Question;

/**
 * Developer : Dhruv Objective : Date : Jun 25, 2022 Time : 3:58:31 PM
 */
public interface QuestionDao {

    /**
     * @param connection
     * @param questions
     * @return
     */
    int insertQuestionDetails(Connection connection, Question questions) throws SQLException;

    /**
     * @param connection
     * @return
     */
    List<Question> fetchQuestionDetails(Connection connection) throws SQLException;

    /**
     * @param connection
     * @param id
     * @return
     */
    Question findQuestionDetail(Connection connection, int id) throws SQLException;

    /**
     * @param connection
     * @param questions
     * @return
     */
    int editQuestionDetail(Connection connection, Question questions) throws SQLException;

    /**
     * @param connection
     * @param id
     * @return
     */
    int modifyQuestionStatus(Connection connection, String id) throws SQLException;

}
