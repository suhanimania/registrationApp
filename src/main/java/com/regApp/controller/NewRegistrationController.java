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

@WebServlet("/saveReg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public NewRegistrationController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if (session.getAttribute("email")!=null) {
			
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DaoService service= new DaoServiceImpl();
		service.connectDb();
		
		service.saveRegistration(name, city, email, mobile);
		
		request.setAttribute("msg", "record is saved!!");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		}catch(Exception e){
			//e.printStackTrace();
			request.setAttribute("error", "Session timeout..login again!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
	}

}
