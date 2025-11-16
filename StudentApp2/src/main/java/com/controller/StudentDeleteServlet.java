package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO dao;
    
    public StudentDeleteServlet() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		int count=dao.deleteStudent(id);
		
		if(count>0) {
			out.print("<h1> STUDENT DELETE SUCCESS </h1>");
			RequestDispatcher rd=request.getRequestDispatcher("/StudentReadServlet");
			rd.include(request, response);
		}
		else
			out.print("<h1> FAILED</h1>");	
		
		
	
	}

}
