package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/FrontContoller", "/front" })
public class FrontContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void init(ServletConfig config) throws ServletException {
		System.out.println("-----FrontController int-----");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("txtEmail");
		String password=request.getParameter("txtPassword");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		System.out.println(!email.isEmpty() && !password.isEmpty());
		
		if(!email.isEmpty() && ! password.isEmpty()) {
			out.print("User is being validated");
			RequestDispatcher dispatcher=request.getRequestDispatcher("validate");
			dispatcher.include(request, response);
			
		}else {
			out.print("Please enter email and password");
			RequestDispatcher dispatcher=request.getRequestDispatcher("existinguser.html");
			dispatcher.include(request, response);
		}
	}

}
