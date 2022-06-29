package com.quizmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.service.QuestionService;
import com.quizmanagementsystem.service.Impl.QuestionServiceImpl;

/**
 * Servlet implementation class DeleteQuestionServlet
 */
public class DeleteQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    QuestionService questionService = new QuestionServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionServlet() {
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
	String id = request.getParameter("id");
	int ans = questionService.changeQuestionStatus(id);
	response.sendRedirect("QuestionList.jsp");
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
