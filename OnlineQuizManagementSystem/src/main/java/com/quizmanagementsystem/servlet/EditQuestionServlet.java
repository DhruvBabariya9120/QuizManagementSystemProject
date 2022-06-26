package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.bean.Question;
import com.quizmanagementsystem.service.CategoryService;
import com.quizmanagementsystem.service.QuestionService;
import com.quizmanagementsystem.service.Impl.CategoryServiceImpl;
import com.quizmanagementsystem.service.Impl.QuestionServiceImpl;

/**
 * Servlet implementation class EditQuestionServlet
 */
public class EditQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    QuestionService questionservice = new QuestionServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuestionServlet() {
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
	int id = Integer.parseInt(request.getParameter("id"));
	Question question = new Question();
	question = questionservice.fetchQuestionDetail(id);
	List<Category> categoryList = categoryService.selectCategoryDetails();
	System.out.println(question);
	request.setAttribute("CategoryDetails", categoryList);
	request.setAttribute("QuestionDetails", question);
	RequestDispatcher dispacher = request.getRequestDispatcher("EditQuestion.jsp");
	dispacher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int question_id = Integer.parseInt(request.getParameter("questionid"));
	int cat_id = Integer.parseInt(request.getParameter("categoryid"));
	String question = request.getParameter("question");
	String option1 = request.getParameter("option1");
	String option2 = request.getParameter("option2");
	String option3 = request.getParameter("option3");
	String option4 = request.getParameter("option4");
	String answer = request.getParameter("answer");

	Question questions = new Question();
	questions.setQuestion_id(question_id);
	questions.setCat_id(cat_id);
	questions.setQuestion(question);
	questions.setOption1(option1);
	questions.setOption2(option2);
	questions.setOption3(option3);
	questions.setOption4(option4);
	questions.setAnswer(answer);

	int ans = questionservice.modifyQuestionDetails(questions);
	if (ans > 0) {
	    response.sendRedirect("QuestionList.jsp");
	}
    }

}
