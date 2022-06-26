package com.quizmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.Category;
import com.quizmanagementsystem.service.CategoryService;
import com.quizmanagementsystem.service.Impl.CategoryServiceImpl;

/**
 * Servlet implementation class EditCategoryServlet
 */
public class EditCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CategoryService cs = new CategoryServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryServlet() {
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
	String cat_Id = request.getParameter("id");

	Category cat = cs.fetchCategoryDetails(cat_Id);

	request.setAttribute("categoryList", cat);

	RequestDispatcher dispatche = request.getRequestDispatcher("EditCategory.jsp");

	dispatche.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	int catid = Integer.parseInt(request.getParameter("categoryid"));
	String catname = request.getParameter("categoryname");

	Category category = new Category();
	category.setCat_id(catid);
	category.setName(catname);

	int val = cs.modifyCategoryDetails(category);

	System.out.println("After update category :- " + val);

	if (val > 0) {

	    request.setAttribute("message", "Category Update Sucessfully...!");

	    response.sendRedirect("DisplaycategoryServlet");
	}
    }

}
