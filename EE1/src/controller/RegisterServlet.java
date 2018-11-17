package controller;

import java.io.IOException;




import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import dbo.DataBaseConnector;
@WebServlet({ "/RegisterServlet", "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("-----RegisterServlet int-----");
	}
		

	public void destroy() {
		System.out.println("-----RegisterServlet destroy-----");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("txtName");
		String email=request.getParameter("txtEmail");
		String password=request.getParameter("txtPassword");
		System.out.println(name+" "+email+" "+password );
		
		response.setContentType("text/html");
		PrintWriter responseOut=response.getWriter();
		
		if(register(name,email,password)) {
			responseOut.print(name+" get registered sucessfully");
			responseOut.close();
		
		}
	}
	boolean register(String name,String email,String password) {
		//StoreUsers su= StoreUsers.getInstance();
		//su.addUser(name,email,password);
		return (new DataBaseConnector().addUser(name,email,password));
	}

}
