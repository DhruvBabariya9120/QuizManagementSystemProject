/**
 * 
 */
package com.quizmanagementsystem.bean;

/**
 * Developer : Dhruv Objective : Date : Jun 22, 2022 Time : 10:24:40 AM
 */
public class Question {

    private int question_id;
    private int cat_id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private int status;

    /**
     * @return the question_id
     */
    public int getQuestion_id() {
	return question_id;
    }

    /**
     * @param question_id the question_id to set
     */
    public void setQuestion_id(int question_id) {
	this.question_id = question_id;
    }

    /**
     * @return the cat_id
     */
    public int getCat_id() {
	return cat_id;
    }

    /**
     * @param cat_id the cat_id to set
     */
    public void setCat_id(int cat_id) {
	this.cat_id = cat_id;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
	return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
	this.question = question;
    }

    /**
     * @return the option1
     */
    public String getOption1() {
	return option1;
    }

    /**
     * @param option1 the option1 to set
     */
    public void setOption1(String option1) {
	this.option1 = option1;
    }

    /**
     * @return the option2
     */
    public String getOption2() {
	return option2;
    }

    /**
     * @param option2 the option2 to set
     */
    public void setOption2(String option2) {
	this.option2 = option2;
    }

    /**
     * @return the option3
     */
    public String getOption3() {
	return option3;
    }

    /**
     * @param option3 the option3 to set
     */
    public void setOption3(String option3) {
	this.option3 = option3;
    }

    /**
     * @return the option4
     */
    public String getOption4() {
	return option4;
    }

    /**
     * @param option4 the option4 to set
     */
    public void setOption4(String option4) {
	this.option4 = option4;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
	return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
	this.answer = answer;
    }

    /**
     * @return the status
     */
    public int getStatus() {
	return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return "Question [question_id=" + question_id + ", cat_id=" + cat_id + ", question=" + question + ", option1="
		+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer="
		+ answer + ", status=" + status + "]";
    }

}
