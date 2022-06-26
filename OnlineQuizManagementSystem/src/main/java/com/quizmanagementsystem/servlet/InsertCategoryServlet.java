package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.service.CategoryService;
import com.quizmanagementsystem.service.Impl.CategoryServiceImpl;

/**
 * Servlet implementation class InsertCategoryServlet
 */
public class InsertCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    CategoryService catService = new CategoryServiceImpl();

    public InsertCategoryServlet() {
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
	String s = request.getParameter("catname");

	List<Category> cat = catService.selectCategoryDetails();

	int flag = 0;
	for (Category c1 : cat) {
	    if (c1.getName().equalsIgnoreCase(s)) {
		flag = 1;
		break;
	    }
	}
	if (flag == 1) {
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

	String categoryname = request.getParameter("categoryname");

	Category category = new Category();

	category.setName(categoryname);

	String str = catService.saveCategoryDetails(category);

	request.setAttribute("message", str);
	RequestDispatcher dispacher = request.getRequestDispatcher("InsertCategory.jsp");
	dispacher.forward(request, response);
    }

}
