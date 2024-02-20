package com.regApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regApp.model.DaoService;
import com.regApp.model.DaoServiceImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LoginController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DaoService service = new DaoServiceImpl();
		service.connectDb();
		
		boolean status = service.verifyLogin(email, password);
		
		if(status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("error","Invalid user name/password");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
	}

}
