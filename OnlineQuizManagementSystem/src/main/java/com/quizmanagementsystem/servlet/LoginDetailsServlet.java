package com.quizmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizmanagementsystem.bean.PasswordConvert;
import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.service.UserService;
import com.quizmanagementsystem.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class LoginDetailsServlet
 */
public class LoginDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserService userservice = new UserServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDetailsServlet() {
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

	HttpSession httpSession = request.getSession(false);
	httpSession.invalidate();
	response.sendRedirect("Login.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String email = request.getParameter("email");
	String password = request.getParameter("password");
	PasswordConvert ps = new PasswordConvert();

	String encryptpassword = ps.encrypt(password);
	User user = userservice.verifyLoginDetails(email, encryptpassword);

	if (null != user.getEmail() && null != user.getPassword() && user.getStatus() == 1) {

	    HttpSession httpSession = request.getSession();
	    httpSession.setAttribute("Logindetails", user);
	    RequestDispatcher dispacher = request.getRequestDispatcher("Index.jsp");
	    dispacher.forward(request, response);
	} else {
	    request.setAttribute("message", "Please Enter valid Email or Password");
	    RequestDispatcher dispacher = request.getRequestDispatcher("Login.jsp");
	    dispacher.forward(request, response);
	}
    }
}
