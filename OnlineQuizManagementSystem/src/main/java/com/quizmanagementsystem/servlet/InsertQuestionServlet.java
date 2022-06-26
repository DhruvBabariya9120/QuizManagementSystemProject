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
 * Servlet implementation class InsertQuestionServlet
 */
public class InsertQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    QuestionService questionService = new QuestionServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestionServlet() {
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
	String question = request.getParameter("question");
	List<Question> questionlist = questionService.selectQuestionDetails();
	int ans = 0;
	for (int i = 0; i < questionlist.size(); i++) {
	    Question questions = questionlist.get(i);
	    if (question.equalsIgnoreCase(questions.getQuestion())) {
		ans = 1;
		break;
	    }
	}

	if (ans > 0) {
	    response.getWriter().append("true");
	} else {
	    response.getWriter().append("false");
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int cat_id = Integer.parseInt(request.getParameter("categoryid"));
	String question = request.getParameter("question");
	String option1 = request.getParameter("option1");
	String option2 = request.getParameter("option2");
	String option3 = request.getParameter("option3");
	String option4 = request.getParameter("option4");
	String answer = request.getParameter("answer");

	Question questions = new Question();
	questions.setCat_id(cat_id);
	questions.setQuestion(question);
	questions.setOption1(option1);
	questions.setOption2(option2);
	questions.setOption3(option3);
	questions.setOption4(option4);
	questions.setAnswer(answer);

	String ans = questionService.saveQuestionDetail(questions);

	request.setAttribute("Message", ans);
	RequestDispatcher dispacher = request.getRequestDispatcher("InsertQuestion.jsp");

	dispacher.forward(request, response);

    }
}
