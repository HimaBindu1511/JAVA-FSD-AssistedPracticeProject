package com.cookieinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String uname=request.getParameter("txtuname");
		String pword=request.getParameter("txtpword");
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatch;
		if(uname.equalsIgnoreCase("Java")&& pword.equals("eclipse@123")) {
			//Create Cookie
			Cookie cookie=new Cookie("username",uname);
			response.addCookie(cookie);
				
			dispatch=request.getRequestDispatcher("login.html");
			dispatch.forward(request,response);// to move to next page Welcome
		
			
		}
		else
			out.println("Invalid User");
		dispatch=request.getRequestDispatcher("Login.html");
		dispatch.include(request,response);
	}
	

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
