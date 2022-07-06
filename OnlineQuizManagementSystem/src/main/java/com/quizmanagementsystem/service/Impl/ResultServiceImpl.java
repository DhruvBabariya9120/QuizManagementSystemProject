/**
 * 
 */
package com.quizmanagementsystem.service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizmanagementsystem.bean.ResultDetails;
import com.quizmanagementsystem.dao.ResultDao;
import com.quizmanagementsystem.dao.Impl.ResultDaoImpl;
import com.quizmanagementsystem.service.ResultService;

/**
 * Developer : Dhruv Objective : Date : Jul 3, 2022 Time : 4:44:54 PM
 */
public class ResultServiceImpl implements ResultService {

    ResultDao resultDao = new ResultDaoImpl();

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
    public int saveResultDetails(ResultDetails result) {
	int ans = 0;
	try (Connection connection = getConnection()) {

	    ans = resultDao.insertResultDetails(connection, result);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return ans;
    }

    @Override
    public List<ResultDetails> selectResultDetails() {
	List<ResultDetails> result = new ArrayList<>();
	try (Connection connection = getConnection()) {
	    result = resultDao.fatchAllResultDetails(connection);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return result;
    }

    @Override
    public List<ResultDetails> findUserResultDetails(int userId) {
	List<ResultDetails> result = new ArrayList<>();

	try (Connection connection = getConnection()) {
	    List<ResultDetails> resultdetailsList = resultDao.fatchAllResultDetails(connection);
	    for (ResultDetails resultdetail : resultdetailsList) {
		if (resultdetail.getUserId() == userId) {
		    result.add(resultdetail);
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return result;
    }

}
