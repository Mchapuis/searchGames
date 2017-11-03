package org.soen387.a1;

import org.soen387.bean.User;
import org.soen387.xml.ReadXMLfile;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/*
 * MARTINE CHAPUIS - ID: 26050980 - SOEN_387
 * 
 * 
 * 
 *  MODEL --- USED TO PROCESS INFORMATION FROM THE FORM 
 *  1- get information from user
 *  2- check if it is valid or not
 *  3- check if userId is already in database
 *  4- record the new user in the database and return a user object for the servlet
 */
	

public final class RegisterForm{
	
	private String result;
	
	public static boolean bValid = false;
	
	//info that will be asked in the register form
    public static final String USERID = "userId";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
    public static final String PASS = "password";
    public static final String CONF = "confirm";
    public static final String ADD_1= "address1";
    public static final String ADD_2 = "address2";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ZIP= "zip";
    public static final String COUNTRY= "country";
    public static final String CREDIT_CARD_NMBR = "credit_card_number";
    public static final String CREDIT_CARD_CVV = "credit_card_cvv";
    public static final String CREDIT_CARD_EXPIRY = "credit_Card_expiry";

    //list errors of user
    public Map<String, String> errors = new HashMap<String, String>();
    
    // result of Registration form validity 
    public String getResult(){
    	return result;
    }
    
    // result of submitting the Registration form - valid or invalid
    private void setResult(String result){
    	this.result = result;
    }
    
    // list of errors to show onthe view
    public Map<String, String> getErrors(){
    	return errors;
    }

    // Get the response from the user and save it to database
	public User registerForm(HttpServletRequest request){
		
		// GET PARAMETERS
		String userId = request.getParameter( USERID );
		String firstName = request.getParameter( FIRST_NAME );
		String lastName = request.getParameter( LAST_NAME );
		String email = request.getParameter( EMAIL );
		String password = request.getParameter( PASS );
		String confirmation = request.getParameter( CONF );
		String address1 = request.getParameter( ADD_1 );
		String address2 = request.getParameter( ADD_2 );
		String city = request.getParameter( CITY );
		String state = request.getParameter( STATE );
		String zip = request.getParameter( ZIP );
		String country = request.getParameter( COUNTRY );
		String credit_card_number = request.getParameter( CREDIT_CARD_NMBR );
		String credit_card_cvv = request.getParameter( CREDIT_CARD_CVV );
		String credit_Card_expiry = request.getParameter( CREDIT_CARD_EXPIRY );

		// creating temp user to save to database
		User user = new User();
		
		// CREATE A USER

		// USERID = check if it is null and if it is already in database
		if( userId != "" ){
			boolean isInDB = IsUserIsAlreadyInDatabase(userId);
			if(isInDB){
				errors.put(USERID, "UserName already exists in database, please user another one");
			}else{
				bValid = true;
				user.setUserId(userId);
			}
		}else{
			errors.put( USERID, "please enter a correct userID" );
			bValid=false;
		}
			
		if( firstName != "" ){
			user.setFirstName(firstName);
		}else{
			errors.put( FIRST_NAME, "please enter a correct first name" );
			bValid=false;
		}
			
		if( lastName != "" ){
			user.setLastName(lastName);
		}else{
			errors.put( LAST_NAME, "please enter a correct last name" );
			bValid=false;
		}
			
		if( email != "" ){
			user.setEmail(email);
		}else{
			errors.put( EMAIL, "please enter a correct email" );
			bValid=false;
		}
		/*  ******************** to do later *****************
		if( password != ""){
			user.setPassword(password);
		}else{
			errors.put( PASS, "please enter a correct password" );
			bValid=false;
		}
			
		if( confirmation != "" && password.equals(confirmation) ){
			user.setConfirm(confirmation);
		}else{
			errors.put( CONF, "please enter a correct confirmation" );
			bValid=false;
		}
			*/ 
		if( address1 != ""){
			user.setAddress1(address1);
		}else{
			errors.put( ADD_1, "please enter a correct address" );
			bValid=false;
		}
			
		if( address2 != ""){
			user.setAddress2(address2);
		}else{
			user.setAddress1("none");
		}
			
		if( city != ""){
			user.setCity(city);
		}else{
			user.setCity("none");
		}
			
		if( state != ""){
			user.setState(state);
		}else{
			user.setCity("none");
		}
			
		if( zip != ""){
			user.setZip(zip);
		}else{
			user.setCity("none");
		}
			
		if( country != ""){
			user.setCountry(country);
		}else{
			user.setCity("none");
		}
			
		if( credit_card_number != "" ){
			user.setCredit_card_number(credit_card_number);
		}else{
			user.setCity("none");
		}
			
		if( credit_card_cvv != ""){
			user.setCredit_card_cvv(credit_card_cvv);
		}else{
			user.setCity("none");
		}
			
		if( credit_Card_expiry != "" ){
			user.setCredit_Card_expiry(credit_Card_expiry);
		}else{
			user.setCity("none");
		}
			
		// IS THE FORM VALID OR NOT
		if(bValid && user.getUserId() != ""){
			
			// YES --> SAVE TO DATABASE
			saveToDatabase(user);
			
			// message to user
			this.setResult(" You are now registered! ");
		}else{
			
			// NO --> REFILL FORM
			// if failed to sign in correctly - message of failure
			this.setResult(" Your registration failed! Please try again! ");
		}
		return user;
	}
	
	
	
	// save a user in the database
	public void saveToDatabase(User user){
		
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/a1_soen387";
		
		
		// Database user and password;
		final String USER = "root";
		final String PASSWORD = "";

		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement prepStmt = null;

			try {
				// Register the driver
			    Class.forName(JDBC_DRIVER);
			    
			    // Open connection
			    conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			    
			    // using prepareStatement against XSS injections
			    String insertUser = "INSERT INTO user "
			    		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    
			    prepStmt = conn.prepareStatement(insertUser);
			    
			    prepStmt.setString(1, user.getUserId());
			    prepStmt.setString(2, user.getFirstName());
			    prepStmt.setString(3, user.getLastName());
			    prepStmt.setString(4, user.getEmail());
			    prepStmt.setString(5, user.getAddress1());
			    prepStmt.setString(6, user.getAddress2());
			    prepStmt.setString(7, user.getCity());
			    prepStmt.setString(8, user.getState());
			    prepStmt.setString(9, user.getZip());
			    prepStmt.setString(10, user.getCountry());
			    prepStmt.setString(11, user.getCredit_card_type());
			    prepStmt.setString(12, user.getCredit_card_number());
			    prepStmt.setString(13, user.getCredit_card_cvv());
			    prepStmt.setString(14, user.getCredit_Card_expiry());
			    
			    System.out.println("In database.. userID : "+ user.getUserId());
			    prepStmt.executeUpdate();
			   
			}catch(MySQLIntegrityConstraintViolationException e){
				
			}catch ( ClassNotFoundException | SQLException e ) {
			    System.out.println("Registering user: "+e);

			}finally{
				System.out.println("DONE!");
				if (conn != null){
					try{
						conn.close();
						prepStmt.close();
					}catch(SQLException ignore){
						// this doesn't mind..
					}
				}
			}
			    	
	}// end to saveToDatabase()

	// scan database to see if user is in it already or not
	public boolean IsUserIsAlreadyInDatabase(String userId){
		boolean isInDB = false;
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
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
		    ResultSet results = stmt.executeQuery("SELECT userId "
			    		+ "FROM user WHERE userId='"+ userId + "';");
		    while(results.next()){
		    	isInDB = true;
		    }
		}catch(ClassNotFoundException e){
			System.out.println("Error in "+ e);
		}catch(SQLException f){
			System.out.println("SQL"+ f);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("User is in database? "+ isInDB);
		return isInDB ? true : false;
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
