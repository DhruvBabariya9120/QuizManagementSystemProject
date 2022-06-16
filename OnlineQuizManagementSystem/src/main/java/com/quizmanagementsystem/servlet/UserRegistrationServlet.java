package com.quizmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.PasswordConvert;
import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.service.UserService;
import com.quizmanagementsystem.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class UserRegistrationServlet
 */
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
	super();

    }

    UserService userservice = new UserServiceImpl();
    User user = new User();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phoneno = request.getParameter("phoneno");
	String gender = request.getParameter("gender");
	String Password = request.getParameter("password");

	PasswordConvert pc = new PasswordConvert();
	String encryptedpassword = pc.encrypt(Password);

	user.setName(name);
	user.setEmail(email);
	user.setContactno(phoneno);
	user.setGender(gender);
	user.setPassword(encryptedpassword);
	user.setRole("user");
	user.setStatus(1);

	String ans = userservice.saveUserDetails(user);

	request.setAttribute("result", ans);
	RequestDispatcher dispacher = request.getRequestDispatcher("Login.jsp");
	dispacher.forward(request, response);

    }

}
