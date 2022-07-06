package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.Question;
import com.quizmanagementsystem.service.QuestionService;
import com.quizmanagementsystem.service.Impl.QuestionServiceImpl;

/**
 * Servlet implementation class DisplayQuizQuestionServlet
 */
public class DisplayQuizQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    QuestionService questionService = new QuestionServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayQuizQuestionServlet() {
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
	int catId = Integer.parseInt(request.getParameter("id"));

	List<Question> questionList = questionService.findQuestionDetails(catId);
	Question question = new Question();
	String message = null;
	if (questionList.isEmpty()) {
	    message = "Question is not Available in this Quiz";
	    request.setAttribute("CatId", catId);
	    request.setAttribute("message", message);
	    RequestDispatcher dispacher = request.getRequestDispatcher("Error.jsp");
	    dispacher.forward(request, response);
	} else {
	    question = questionList.get(0);

	    int lastQuestion = 0;
	    if (questionList.size() == 1) {
		lastQuestion = 1;
	    }
	    request.setAttribute("SelectedQuestion", question);
	    request.setAttribute("message", message);
	    request.setAttribute("CategoryId", catId);
	    request.setAttribute("LastQuestion", lastQuestion);
	    RequestDispatcher dispacher = request.getRequestDispatcher("QuizQuestionShow.jsp");
	    dispacher.forward(request, response);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
