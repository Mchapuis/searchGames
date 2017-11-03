package org.soen387.a1;

import org.soen387.bean.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String JSP_LOGIN_PATH = "/WEB-INF/login.jsp";
	public static final String JSP_SEARCH_PATH = "/WEB-INF/search.jsp";
	public static final String USERID ="userId";
	public static final String LOGIN = "login";
	public String action = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// show login page with empty inputs
		this.getServletContext().getRequestDispatcher( JSP_LOGIN_PATH ).forward(request, response);

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// new login
		LoginForm login = new LoginForm();
		
		// get user from this login attempt
		User user = login.registerForm(request);
		HttpSession session = request.getSession();
		String getResult = login.getResult();
		// add elements to session request
		request.setAttribute(LOGIN, login);
		request.setAttribute(USERID, user);
		
		
		// if all validation was ok, add bean to session, else not
		System.out.println("login "+getResult);
		if(getResult.equals("pass")){
			session.setAttribute(USERID, user);
			response.sendRedirect("/a1/search");

		}else if(getResult.equals("fail")){
			//System.out.println("faiiilll");
			session.setAttribute(USERID, null);
			response.sendRedirect("/a1/login");
		}
	}
}
