/**
 * 
 */
package com.quizmanagementsystem.service;

import java.util.List;

import com.quizmanagementsystem.bean.ResultDetails;

/**
 * Developer : Dhruv Objective : Date : Jul 3, 2022 Time : 4:42:59 PM
 */
public interface ResultService {

    /**
     * @param result
     * @return
     */
    int saveResultDetails(ResultDetails result);

    /**
     * @return
     */
    List<ResultDetails> selectResultDetails();

    List<ResultDetails> findUserResultDetails(int userId);

}
