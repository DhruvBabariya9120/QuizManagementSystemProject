package com.quizmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.service.UserService;
import com.quizmanagementsystem.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class ForgetpasswordServlet
 */
public class ForgetpasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserService service = new UserServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetpasswordServlet() {
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

	String email = request.getParameter("email");

	int n = service.Checkemaildetails(email);

	if (n == 0) {
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
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
