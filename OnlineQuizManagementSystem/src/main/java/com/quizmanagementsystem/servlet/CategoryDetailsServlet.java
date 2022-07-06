package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.service.CategoryService;
import com.quizmanagementsystem.service.Impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryDetailsServlet
 */
public class CategoryDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CategoryService catservice = new CategoryServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDetailsServlet() {
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
	List<Category> cat = catservice.selectCategoryDetails();

	request.setAttribute("CategoryDetails", cat);
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
