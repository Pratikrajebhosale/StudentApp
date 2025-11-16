package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HelloServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("uname");
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		
		out.print("<body>");
		
		out.print("<h1>");
//		out.print("Hello Servlet");
		out.print(name.toUpperCase());
		out.print("</h1>");
		
		out.print("</body>");
		
		out.print("</html>");
	
	}

}
