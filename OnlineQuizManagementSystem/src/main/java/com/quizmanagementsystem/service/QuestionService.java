/**
 * 
 */
package com.quizmanagementsystem.service;

import java.util.List;

import com.quizmanagementsystem.bean.Question;

/**
 * Developer : Dhruv Objective : Date : Jun 25, 2022 Time : 4:02:15 PM
 */
public interface QuestionService {

    /**
     * @param questions
     * @return
     */
    String saveQuestionDetail(Question questions);

    /**
     * @param question
     * @return
     */
    List<Question> selectQuestionDetails();

    /**
     * @param id
     * @return
     */
    Question fetchQuestionDetail(int id);

    /**
     * @param questions
     * @return
     */
    int modifyQuestionDetails(Question questions);

    /**
     * @return
     */

}
