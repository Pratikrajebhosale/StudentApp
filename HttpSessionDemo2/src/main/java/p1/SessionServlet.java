package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<h1>Welcome</h1>");
		
		
		HttpSession session=request.getSession(false);
		
		if(session!=null) {
			
			
			
		}
		else
		{
			session=request.getSession();
		}
		
		out.print("<h1> Session Id:"+ session.getId()+"</h1><br>");
		out.print("<h1> Session Creation Time:"+ session.getCreationTime()+"</h1><br>");
		out.print("<h1> Session Creation Time:"+ new Date(session.getCreationTime())+"</h1><br>");
		out.print("<h1> Session Last Acess Time:"+ new Date(session.getLastAccessedTime())+"</h1><br>");
		out.print("<h1> Session Get MAx Time Time:"+ session.getMaxInactiveInterval()+"</h1><br>");
		
		session.setMaxInactiveInterval(60);
		out.print("<h1> Session Get MAx Time Time:"+ session.getMaxInactiveInterval()+"</h1><br>");

		
	}

}
