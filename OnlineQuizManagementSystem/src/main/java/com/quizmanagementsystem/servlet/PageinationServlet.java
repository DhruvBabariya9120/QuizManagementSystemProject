package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizmanagementsystem.bean.Question;
import com.quizmanagementsystem.bean.ResultDetails;
import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.service.QuestionService;
import com.quizmanagementsystem.service.ResultService;
import com.quizmanagementsystem.service.Impl.QuestionServiceImpl;
import com.quizmanagementsystem.service.Impl.ResultServiceImpl;

/**
 * Servlet implementation class PageinationServlet
 */
public class PageinationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    QuestionService questionservice = new QuestionServiceImpl();
    ResultService resultService = new ResultServiceImpl();
    static List<Boolean> answer = new ArrayList<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageinationServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	int qid = Integer.parseInt(request.getParameter("qid"));
	String buttonname = request.getParameter("submitbutton");
	String ans = request.getParameter("Answer");

	List<Question> questionList = questionservice.findQuestionDetails(id);
	boolean value = false;
	int index = 0;
	for (int i = 0; i < questionList.size(); i++) {
	    Question question = questionList.get(i);

	    if (question.getQuestion_id() == qid) {
		if (question.getAnswer().equalsIgnoreCase(ans)) {
		    value = true;
		} else {
		    value = false;
		}
		index = (i + 1);
	    }
	}
	int lastQuestion = 0;
	if (index == questionList.size() - 1) {
	    lastQuestion = 1;
	}
	int cnt = 0;
	int totalQuestion = 0;
	answer.add(value);
	int cnt1 = answer.size();
	System.out.println("answer = " + answer);
	request.setAttribute("LastQuestion", lastQuestion);
	request.setAttribute("CategoryId", id);

	if (buttonname == null) {
	    Question que = questionList.get(index);
	    request.setAttribute("SelectedQuestion", que);
	    request.setAttribute("counter", cnt1);
	    RequestDispatcher dispacher = request.getRequestDispatcher("QuizQuestionShow.jsp");
	    dispacher.forward(request, response);
	} else {
	    for (Boolean b : answer) {
		totalQuestion++;
		if (b == true)
		    cnt++;
	    }
	    System.out.println("total = " + totalQuestion);
	    System.out.println("answer = " + cnt);
	    HttpSession session = request.getSession(false);
	    User user = (User) session.getAttribute("Logindetails");
	    double percentage = (cnt * 100 / totalQuestion);
	    System.out.println("percentage = " + percentage);
	    String performance = null;
	    if (percentage < 40) {
		performance = "Poor";
	    } else if (percentage >= 40 && percentage < 60) {
		performance = "Good";
	    } else if (percentage >= 60 && percentage < 80) {
		performance = "Very Good";
	    } else {
		performance = "Excellent";
	    }
	    ResultDetails result = new ResultDetails();
	    result.setCatId(id);
	    result.setObtainmarks(cnt);
	    result.setTotalmarks(totalQuestion);
	    result.setUserId(user.getId());
	    result.setPerformance(performance);

	    answer.clear();
	    int ans1 = resultService.saveResultDetails(result);
	    request.setAttribute("ResultData", result);
	    request.setAttribute("QuestionList", questionList);
	    RequestDispatcher dispacher = request.getRequestDispatcher("ViewResult.jsp");
	    dispacher.forward(request, response);

	}

    }
}
