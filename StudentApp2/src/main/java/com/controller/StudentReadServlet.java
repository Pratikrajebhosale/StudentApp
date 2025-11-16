package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

/**
 * Servlet implementation class StudentReadServlet
 */
@WebServlet("/StudentReadServlet")
public class StudentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentReadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Student> list = dao.getAllStudent();

		Iterator<Student> itr = list.iterator();
		out.print("<head>");

		out.print("<link rel=\"stylesheet\" href=\"CSS/table.css\">");

		out.print("</head>");
		out.print("<table border='1px solid black'>");

		out.print("<tr>" + "<th>ID</th>" + "<th>NAME</th>" + "<th>MARKS</th>" + "<th>DELETE</th>" + "<th>UPDATE</th>" + "</tr>");
		while (itr.hasNext()) {
			Student student = itr.next();
			out.print("<tr><td>");
			out.print(student.getId());
			out.print("</td><td>");
			out.print(student.getName());
			out.print("</td><td>");
			out.print(student.getMarks());
			out.print("</td><td>");
				// anchor tag to StudentDeleteServlet
				// StudentDeleteServlet?id=
			out.print("<a href='StudentDeleteServlet?id="+student.getId()+"'>DELETE</a>");
			out.print("</td><td>");
			out.print("<a href='StudentUpdateForm?id="+student.getId()+"'>UPDATE</a>");
			out.print("</td></tr>");
		}

		out.print("</table>");

	}

}
