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

import com.quizmanagementsystem.bean.ResultDetails;
import com.quizmanagementsystem.dao.ResultDao;

/**
 * Developer : Dhruv Objective : Date : Jul 3, 2022 Time : 4:41:03 PM
 */
public class ResultDaoImpl implements ResultDao {

    @Override
    public int insertResultDetails(Connection connection, ResultDetails result) throws SQLException {
	int ans = 0;
	try (PreparedStatement ps = connection.prepareStatement(
		"insert into quizresult(cat_id, user_id, obtainmarks, totalmarks, performance) values(?,?,?,?,?)")) {
	    ps.setInt(1, result.getCatId());
	    ps.setInt(2, result.getUserId());
	    ps.setInt(3, result.getObtainmarks());
	    ps.setInt(4, result.getTotalmarks());
	    ps.setString(5, result.getPerformance());
	    ans = ps.executeUpdate();
	}
	return ans;
    }

    @Override
    public List<ResultDetails> fatchAllResultDetails(Connection connection) throws SQLException {
	List<ResultDetails> result = new ArrayList<>();
	try (PreparedStatement ps = connection.prepareStatement("select * from quizresult");
		ResultSet resultset = ps.executeQuery()) {

	    while (resultset.next()) {
		ResultDetails resultDetails = new ResultDetails();
		resultDetails.setResultId(resultset.getInt(1));
		resultDetails.setCatId(resultset.getInt(2));
		resultDetails.setUserId(resultset.getInt(3));
		resultDetails.setObtainmarks(resultset.getInt(4));
		resultDetails.setTotalmarks(resultset.getInt(5));
		resultDetails.setPerformance(resultset.getString(6));
		resultDetails.setStatus(resultset.getInt(7));
		result.add(resultDetails);
	    }

	}
	return result;
    }

}
