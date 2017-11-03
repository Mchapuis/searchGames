package org.soen387.a1;

import org.soen387.bean.User;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/*
 * MARTINE CHAPUIS - ID: 26050980 - SOEN_387
 * 
 *  MODEL --- USED TO PROCESS INFORMATION FROM THE FORM 
 */

public final class LoginForm {
	
	public static final String USERID = "userId";
	public Map<String, String> errors = new HashMap<String, String>();
	private String result;
	
	//constructor
	public LoginForm(){
		this.result = "hello";
	};
	
	// result from the verification
	public String getResult(){
		return this.result;
	}
	
	private void setResult(String result){
		this.result = result;
	}
	/*
	 * return null if not in database, else return a user with all the info
	 * 
	 * CASE 1: If user is in the database                
	 * Create User as a Bean and send it back to servlet 
     * CASE 2: If user is NOT in the database            
     * Ask user to register or retype their username     
	 */
	public User registerForm(HttpServletRequest request){
		
		String userId = request.getParameter(USERID);
		User user = null;
		setResult("fail");
		
		if(userId != ""){
			user = validateUserName(userId);
			if(user != null) // if verification passed
				setResult("pass");
			else{
				setResult("fail");
			}
		}
		else if(userId == null || userId == "" ){
			errors.put(USERID, "UserID is not in database, please try again or register");
			setResult("fail");
		}
		return user; 
	}
	
	// return list of errors
	public Map<String, String> getErrors(){
		return errors;
	}

	
	// Look in Database to see it the user is there
	@SuppressWarnings("null")
	public User validateUserName( String userName ){
		// generate the user
		User user = null;
		boolean bInDatabase = false;
		// Open Database
		// JDBC driver name and database URL
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		
		// connect to database
		final String DB_URL = "jdbc:mysql://localhost:3306/a1_soen387";
		
		
		// Database user and password;
		final String USER = "root";
		final String PASSWORD = "";

		Connection conn = null;
		Statement stmt = null;
		
		try {
			// Register the driver
		    Class.forName(JDBC_DRIVER);
		    
		    // Open connection
		    conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		    stmt = conn.createStatement();
		    
		    // Asking to check if the userName is there

		    ResultSet results = stmt.executeQuery("SELECT * "
			    		+ "FROM user WHERE userId='"+ userName+"'");
		    
		    String userId = "";
		    String firstName = "";
		    String lastName = "";
		    String email = "";
		    String address1 = "";
		    String address2 = "";
		    String city = "";
		    String state = "";
		    String zip = "";
		    String country = "";
		    String credit_card_number = "";
		    String credit_card_cvv = "";
		    String credit_Card_expiry = "";
		    
		    // Getting all the info from user
		    while(results.next()){
		    	user = new User();
		    	userId = results.getString(USERID); 
		    	System.out.println("userID is "+userId);
		    	
		    	// here we need to get the full user from the id
		    	
		    	firstName = results.getString(2);
		    	System.out.println("firstname"+firstName);
		    	
		    	lastName = results.getString(3);
		    	System.out.println("lastname"+lastName);
		    	
		    	email = results.getString(4);
		    	System.out.println("email"+email);
		    	
		    	//String password = results.getString(5);
		    	//String confirmation = results.getString(6);
		    	address1 = results.getString(5);
		    	System.out.println("address1"+address1);
		    	
		    	address2 = results.getString(6);
		    	System.out.println("addres2"+address2);
		    	
		    	if(results.getString(7) != null)
		    		city = results.getString(7);
		    	if(results.getString(8) != null)
		    		state = results.getString(8);
		    	if(results.getString(9) != null)
		    		zip = results.getString(9);
		    	if(results.getString(10) != null)
		    		country = results.getString(10);
		    	if(results.getString(11) != null)
		    		credit_card_number = results.getString(11);
		    	if(results.getString(12) != null)
		    		credit_card_cvv = results.getString(12);
		    	if(results.getString(13) != null)
		    		credit_Card_expiry = results.getString(13);
		    	
		    	bInDatabase = true;
		    	
		    	user.setUserId(userId);
		    	user.setFirstName(firstName);
		    	user.setLastName(lastName);
		    	user.setEmail(email);
		    	//user.setPassword();
		    	//user.setConfirmation();
		    	user.setAddress1(address1);
		    	
		    	user.setAddress2(address2);
		    	user.setCity(city);
		    	user.setState(state);
		    	user.setZip(zip);
		    	user.setCountry(country);
		    	user.setCredit_card_number(credit_card_number);
		    	user.setCredit_card_cvv(credit_card_cvv);
		    	user.setCredit_Card_expiry(credit_Card_expiry);
		    }
		   
		    
		}catch(ClassNotFoundException | SQLException e){
			System.out.println("SQL !!!! error:"+e);
		}finally{
			if(conn != null){
				try{
					conn.close();
					stmt.close();
				}catch( SQLException e){
					System.out.println("Closing connection error"+e);
				}
			}
		}
		/// return TRUE if the userName is in the database
	    return user;
	}// end of validateUserName
	

}
