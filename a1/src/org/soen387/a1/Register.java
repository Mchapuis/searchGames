package org.soen387.a1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.bean.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//path to get the jsp 
	public static final String JSP_PATH = "/WEB-INF/register.jsp";
	public static final String USER = "user";
	public static final String FORM = "form";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// show register page with empty inputs
		this.getServletContext().getRequestDispatcher( JSP_PATH ).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// model to process information form user 
		RegisterForm form = new RegisterForm();
		
		// the function return a user with all the information
		User user = form.registerForm(request);
		
		request.setAttribute(FORM, form);
		request.setAttribute(USER, user);
		
		this.getServletContext().getRequestDispatcher( JSP_PATH ).forward( request, response );

	}

}


























// ************************ TO DO LATER ************************************


/*
// ******************************************
// VALIDITY OF PASSWORD AND EMAIL 
// ******************************************

private void validEmail(String email) throws Exception{

	if(email != null ){
		if(!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )){
			throw new Exception("The format is not valid");
		}
	}else{
		throw new Exception("Please enter an email address");
	}
		
}

//validity of password
private void validPassword(String password, String confirmation) throws Exception{
	// chekc if they are the same
	if(password != null){
		if(!password.equals(confirmation)){
			throw new Exception("Password and confirmation are not the same");
		}
	}
	
}*/
