package com.regApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.regApp.model.DaoService;
import com.regApp.model.DaoServiceImpl;



@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		DaoService service = new DaoServiceImpl();
		//System.out.println(1);
		service.connectDb();
		//System.out.println(2);
		service.updateRegistration(email,mobile);
		//System.out.println(3);
		ResultSet results = service.getAllRegistration();
		request.setAttribute("results", results);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registrations.jsp");
		rd.forward(request, response);
		
		
	
	}

}
