package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import dummydb.StoreUsers;
//import dummydb.User;
import dbo.DataBaseConnector;

@WebServlet({ "/ValidateServlet", "/validate" })
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void init(ServletConfig config) throws ServletException {
		System.out.println("-----ValidateServlet int-----");
	}
	public void destroy() {
		System.out.println("-----ValidateServletdstroy-----");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email=request.getParameter("txtEmail");
		String password=request.getParameter("txtPassword");
		
		response.setContentType("text/html");
		PrintWriter responseOut=response.getWriter();
		
		if(validateLogin( email, password)){
			responseOut.print("You are logged in.");
			responseOut.print("<a href='home'>Enter Home</a>");
		}else{
			responseOut.print("Infromation enetered doesnot match.");
		}
	}
	
	private boolean validateLogin (String email,String password) {
		//StoreUsers su= StoreUsers.getInstance();
		//for(User u:su.getList()) {
			//if(email.equals(u.getEmail())&&password.equals(u.getPassword())) 
				//return true;
		//}
		//return false;
		return new DataBaseConnector().validateEmailandPassword(email, password);
	}

}
