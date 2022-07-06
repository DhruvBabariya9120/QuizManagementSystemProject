/**
 * 
 */
package com.quizmanagementsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.quizmanagementsystem.bean.ResultDetails;

/**
 * Developer : Dhruv Objective : Date : Jul 3, 2022 Time : 4:40:31 PM
 */
public interface ResultDao {

    /**
     * @param connection
     * @param result
     * @return
     */
    int insertResultDetails(Connection connection, ResultDetails result) throws SQLException;

    /**
     * @return
     */
    List<ResultDetails> fatchAllResultDetails(Connection connection) throws SQLException;

}
