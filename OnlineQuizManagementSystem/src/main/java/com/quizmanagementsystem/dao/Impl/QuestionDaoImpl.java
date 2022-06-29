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

import com.quizmanagementsystem.bean.Question;
import com.quizmanagementsystem.dao.QuestionDao;

/**
 * Developer : Dhruv Objective : Date : Jun 25, 2022 Time : 4:01:48 PM
 */
public class QuestionDaoImpl implements QuestionDao {

    @Override
    public int insertQuestionDetails(Connection connection, Question questions) throws SQLException {
	int ans = 0;
	try (PreparedStatement ps = connection.prepareStatement(
		"insert into question_answer(category_id, question, que_option1, que_option2, que_option3, que_option4, answer) values(?,?,?,?,?,?,?)")) {
	    ps.setInt(1, questions.getCat_id());
	    ps.setString(2, questions.getQuestion());
	    ps.setString(3, questions.getOption1());
	    ps.setString(4, questions.getOption2());
	    ps.setString(5, questions.getOption3());
	    ps.setString(6, questions.getOption4());
	    ps.setString(7, questions.getAnswer());

	    ans = ps.executeUpdate();
	}
	return ans;
    }

    @Override
    public List<Question> fetchQuestionDetails(Connection connection) throws SQLException {
	List<Question> questionList = new ArrayList<>();
	try (PreparedStatement ps = connection.prepareStatement("select * from question_answer")) {
	    ResultSet resultset = ps.executeQuery();

	    while (resultset.next()) {
		Question question = new Question();
		question.setQuestion_id(resultset.getInt(1));
		question.setCat_id(resultset.getInt(2));
		question.setQuestion(resultset.getString(3));
		question.setOption1(resultset.getString(4));
		question.setOption2(resultset.getString(5));
		question.setOption3(resultset.getString(6));
		question.setOption4(resultset.getString(7));
		question.setAnswer(resultset.getString(8));
		question.setStatus(resultset.getInt(9));
		questionList.add(question);
	    }
	}
	return questionList;
    }

    @Override
    public Question findQuestionDetail(Connection connection, int id) throws SQLException {
	Question question = new Question();
	try (PreparedStatement ps = connection.prepareStatement("select * from question_answer where question_id=?")) {
	    ps.setInt(1, id);
	    ResultSet resultset = ps.executeQuery();
	    while (resultset.next()) {
		question.setQuestion_id(resultset.getInt(1));
		question.setCat_id(resultset.getInt(2));
		question.setQuestion(resultset.getString(3));
		question.setOption1(resultset.getString(4));
		question.setOption2(resultset.getString(5));
		question.setOption3(resultset.getString(6));
		question.setOption4(resultset.getString(7));
		question.setAnswer(resultset.getString(8));
		question.setStatus(resultset.getInt(9));
	    }
	}
	return question;
    }

    @Override
    public int editQuestionDetail(Connection connection, Question questions) throws SQLException {
	int ans = 0;
	String updateQuery = "update question_answer set category_id=?, question=?,"
		+ "que_option1=?, que_option2=?, que_option3=?, que_option4=?, " + "answer=? where question_id= ?";
	try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
	    ps.setInt(1, questions.getCat_id());
	    ps.setString(2, questions.getQuestion());
	    ps.setString(3, questions.getOption1());
	    ps.setString(4, questions.getOption2());
	    ps.setString(5, questions.getOption3());
	    ps.setString(6, questions.getOption4());
	    ps.setString(7, questions.getAnswer());
	    ps.setInt(8, questions.getQuestion_id());
	    ans = ps.executeUpdate();
	}
	return ans;
    }

    @Override
    public int modifyQuestionStatus(Connection connection, String id) throws SQLException {
	int ans = 0;
	int status = 0;
	try (PreparedStatement ps = connection.prepareStatement("select * from question_answer where question_id=?")) {
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
	try (PreparedStatement ps1 = connection
		.prepareStatement("update question_answer set status=? where question_id=?")) {
	    ps1.setInt(1, status);
	    ps1.setInt(2, Integer.parseInt(id));
	    ans = ps1.executeUpdate();
	}
	return ans;
    }

}
