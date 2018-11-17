package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		name = "HomeServlet", 
		urlPatterns = { 
				"/HomeServlet", 
				"/home"
		})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void init(ServletConfig config) throws ServletException {
		System.out.println("-----Home int-----");
	}
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String dateTime= new Date().toString();
		out.print("<html> "
				+ "<body><center>"
				+"<h3> Welcome Dear User</h3>"
				+"<h4> Its "+dateTime+"</h3>"
				+"</center></body>"
				+"</html>");
	}

}
