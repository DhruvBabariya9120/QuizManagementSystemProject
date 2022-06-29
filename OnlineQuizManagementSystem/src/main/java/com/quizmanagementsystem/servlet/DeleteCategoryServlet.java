package com.quizmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.service.CategoryService;
import com.quizmanagementsystem.service.Impl.CategoryServiceImpl;

/**
 * Servlet implementation class DeleteCategoryServlet
 */
public class DeleteCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CategoryService catService = new CategoryServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryServlet() {
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
	int ans = catService.changeCategoryStatus(id);
	response.sendRedirect("DisplaycategoryServlet");
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
