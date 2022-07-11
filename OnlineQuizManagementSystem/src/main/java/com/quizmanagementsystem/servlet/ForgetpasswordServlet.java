package com.quizmanagementsystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizmanagementsystem.bean.PasswordConvert;
import com.quizmanagementsystem.bean.User;
import com.quizmanagementsystem.service.UserService;
import com.quizmanagementsystem.service.Impl.UserServiceImpl;
import com.quizmanagementsystem.util.SendEmail;

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
	String email = request.getParameter("email");

	List<User> userList = service.selectUserDetails();

	String password = null;
	for (User user : userList) {
	    if (user.getEmail().equals(email)) {
		password = user.getPassword();
	    }
	}
	PasswordConvert ps = new PasswordConvert();
	String originalPassword = ps.decrypt(password);
	SendEmail sendEmail = new SendEmail();
	String msg = " Your Password  = " + originalPassword;
	sendEmail.senmail(email, msg);
	Thread t1 = new Thread(sendEmail);
	t1.start();
	request.setAttribute("message", "Password Send in Your Email Successfully");
	RequestDispatcher dispacher = request.getRequestDispatcher("Login.jsp");
	dispacher.forward(request, response);
    }

}
