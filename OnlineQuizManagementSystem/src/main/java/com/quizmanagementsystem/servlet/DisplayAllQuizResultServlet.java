package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.bean.ResultDetails;
import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.service.CategoryService;
import com.quizmanagementsystem.service.ResultService;
import com.quizmanagementsystem.service.Impl.CategoryServiceImpl;
import com.quizmanagementsystem.service.Impl.ResultServiceImpl;

/**
 * Servlet implementation class DisplayAllQuizResultServlet
 */
public class DisplayAllQuizResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CategoryService catService = new CategoryServiceImpl();
    ResultService resultService = new ResultServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllQuizResultServlet() {
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

	List<Category> categoryList = catService.selectCategoryDetails();
	HttpSession session = request.getSession(false);
	User u = (User) session.getAttribute("Logindetails");
	List<ResultDetails> result = resultService.selectResultDetails();
	List<ResultDetails> resultList = resultService.findUserResultDetails(u.getId());
	request.setAttribute("CategoryList", categoryList);
	request.setAttribute("resultList", result);
	request.setAttribute("ResultList", resultList);
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
