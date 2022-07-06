/**
 * 
 */
package com.quizmanagementsystem.bean;

/**
 * Developer : Dhruv Objective : Date : Jul 3, 2022 Time : 3:34:48 PM
 */
public class ResultDetails {

    int resultId;
    int catId;
    int userId;
    int obtainmarks;
    int totalmarks;
    String performance;
    int status;

    /**
     * @return the resultId
     */
    public int getResultId() {
	return resultId;
    }

    /**
     * @param resultId the resultId to set
     */
    public void setResultId(int resultId) {
	this.resultId = resultId;
    }

    /**
     * @return the catId
     */
    public int getCatId() {
	return catId;
    }

    /**
     * @param catId the catId to set
     */
    public void setCatId(int catId) {
	this.catId = catId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
	return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
	this.userId = userId;
    }

    /**
     * @return the obtainmarks
     */
    public int getObtainmarks() {
	return obtainmarks;
    }

    /**
     * @param obtainmarks the obtainmarks to set
     */
    public void setObtainmarks(int obtainmarks) {
	this.obtainmarks = obtainmarks;
    }

    /**
     * @return the totalmarks
     */
    public int getTotalmarks() {
	return totalmarks;
    }

    /**
     * @param totalmarks the totalmarks to set
     */
    public void setTotalmarks(int totalmarks) {
	this.totalmarks = totalmarks;
    }

    /**
     * @return the performance
     */
    public String getPerformance() {
	return performance;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(String performance) {
	this.performance = performance;
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
	return "ResultDetails [resultId=" + resultId + ", catId=" + catId + ", userId=" + userId + ", obtainmarks="
		+ obtainmarks + ", totalmarks=" + totalmarks + ", performance=" + performance + ", status=" + status
		+ "]";
    }

}
