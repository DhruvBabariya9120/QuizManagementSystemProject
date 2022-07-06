/**
 * 
 */
package com.quizmanagementsystem.service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizmanagementsystem.bean.Question;
import com.quizmanagementsystem.dao.QuestionDao;
import com.quizmanagementsystem.dao.Impl.QuestionDaoImpl;
import com.quizmanagementsystem.service.QuestionService;

/**
 * Developer : Dhruv Objective : Date : Jun 25, 2022 Time : 4:03:15 PM
 */
public class QuestionServiceImpl implements QuestionService {

    QuestionDao questiondao = new QuestionDaoImpl();

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
    public String saveQuestionDetail(Question questions) {
	String str = "";
	try (Connection connection = getConnection()) {

	    int ans = questiondao.insertQuestionDetails(connection, questions);
	    if (ans > 0) {
		str = "Data Insert Successful";
	    } else {
		str = "Data Not Insert Successful";
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return str;
    }

    @Override
    public List<Question> selectQuestionDetails() {

	List<Question> questionlist = new ArrayList<>();

	try (Connection connection = getConnection()) {

	    questionlist = questiondao.fetchQuestionDetails(connection);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return questionlist;
    }

    @Override
    public Question fetchQuestionDetail(int id) {
	Question question = new Question();
	try (Connection connection = getConnection()) {

	    question = questiondao.findQuestionDetail(connection, id);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return question;
    }

    @Override
    public int modifyQuestionDetails(Question questions) {
	int ans = 0;
	try (Connection connection = getConnection()) {

	    ans = questiondao.editQuestionDetail(connection, questions);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return ans;
    }

    @Override
    public int changeQuestionStatus(String id) {
	int ans = 0;
	try (Connection connection = getConnection()) {
	    ans = questiondao.modifyQuestionStatus(connection, id);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return ans;
    }

    @Override
    public List<Question> findQuestionDetails(int catId) {
	List<Question> questionList = new ArrayList<>();
	try (Connection connection = getConnection()) {

	    List<Question> queList = questiondao.fetchQuestionDetails(connection);
	    for (Question question : queList) {
		if (question.getCat_id() == catId && question.getStatus() == 1) {
		    questionList.add(question);
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return questionList;
    }

}
