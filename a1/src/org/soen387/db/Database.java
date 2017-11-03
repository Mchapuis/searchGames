package org.soen387.db;

import org.soen387.xml.GameData;
import org.soen387.xml.ReadXMLfile;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class Database {
	
	// Create my xml object that is parsed and ready to be imported into the database;
	static ReadXMLfile xFile = new ReadXMLfile();
	static int idIfNull = 10000;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	
	
	// Database user and password;
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void main(String[] args) {
	
	//public void createDB( HttpServletRequest request){
	
	//constructor for the database
	//Database(){
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null; // better than stmt

		try {
			// Register the driver
		    Class.forName(JDBC_DRIVER);
		    
		    // Open connection
		    conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		    
		    
		    // 1- Get all the database names
		    System.out.println("Creating database...");
		    
		    ResultSet resultSet = conn.getMetaData().getCatalogs();
		    String db_name = null;
		    boolean bExist = false;
		    
		    // 2- Iterate throught the database to find if it has been created
		    while( resultSet.next() ){
		    	db_name = resultSet.getString(1);
		    	System.out.println(db_name);
		    	if( db_name.equals("a1_soen387") ){
		    		System.out.println("a1_soen387 exists");
		    		bExist = true;
		    	}
		    		
		    }
		    resultSet.close();
		    stmt = conn.createStatement();
		    
		    // 3- If the database doesn't exist, create it
		    if(!bExist){  
		    	System.out.println("database doesn't exists so we create it..");
		    	stmt.executeUpdate("CREATE DATABASE a1_soen387");
		    }
		    
		    //System.out.println("create database..");
		    //stmt.executeUpdate("CREATE DATABASE a1_soen387");
		    System.out.println("use database..");
		    stmt.execute("USE a1_soen387");
		    stmt.executeUpdate("SET @@global.sql_mode= 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'");
		    System.out.println("create table..");
		    
		    String zeTable = "CREATE TABLE gameData"+
		    "( id VARCHAR(20) not NULL, " +
		    " gameTitle MEDIUMBLOB NULL DEFAULT NULL, " +
		    " releaseDate VARCHAR(60) NULL DEFAULT NULL, "+
		    " platform VARCHAR(100) NULL DEFAULT NULL, " +
		    " Overview VARCHAR(10000) NULL DEFAULT NULL, "+
		    " num_players VARCHAR(10) NULL DEFAULT NULL, "+
		    " coop VARCHAR(10), "+
		    " genre VARCHAR(50),"+
		    " developer VARCHAR(100),"+
		    " publisher VARCHAR(60),"+
		    " front_box_art VARCHAR(250),"+
		    " back_box_art VARCHAR(250),"+
		    " logo VARCHAR(40),"+
		    " developer_logo VARCHAR(250),"+
		    " comments VARCHAR(250),"+
		    " PRIMARY KEY(id))";

		    // create the tables in mysql
		    stmt.executeUpdate(zeTable);
		    
		    // get the list of gameData
		    List<GameData> gd = xFile.getGameData();
		    
		    
		    // get xFile object and extract each object
		    for(int j=0; j<70;j++){
		    	
		    	//give random id if null
		    	String myId = gd.get(j).getId();
		    	if(gd.get(j).getId() == null){
		    		idIfNull++;
		    		myId = ""+idIfNull;
		    	}
		    	
		    	String insertIntoTable = "INSERT INTO gameData "
		    			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		    	
		    	prepStmt = conn.prepareStatement(insertIntoTable);
		    	prepStmt.setString(1, myId);
		    	prepStmt.setString(2, gd.get(j).getGameTitle());
		    	System.out.println(gd.get(j).getGameTitle());
		    	prepStmt.setString(3, gd.get(j).getReleaseDate());
		    	prepStmt.setString(4, gd.get(j).getPlatform());
		    	prepStmt.setString(5, gd.get(j).getOverview());
		    	prepStmt.setString(6, gd.get(j).getNum_players());
		    	prepStmt.setString(7, gd.get(j).getCoop());
		    	prepStmt.setString(8, gd.get(j).getGenre());
		    	prepStmt.setString(9, gd.get(j).getDeveloper());
		    	prepStmt.setString(10, gd.get(j).getPublisher());
		    	prepStmt.setString(11, gd.get(j).getFront_box_art());
		    	prepStmt.setString(12, gd.get(j).getBack_box_art());
		    	prepStmt.setString(13, gd.get(j).getLogo());
		    	prepStmt.setString(14, gd.get(j).getDeveloper_logo());
		    	prepStmt.setString(15, gd.get(j).getComments());
		    	
		    	prepStmt.executeUpdate();
		    	
		    	
		    }//end of loop
		    
		   // creating user tables
		    String zeUserTable = "CREATE TABLE user"+
		    "( userId VARCHAR(250) not NULL, "+
		    "firstName VARCHAR(250),"+
		    "lastName VARCHAR(250),"+
		    "email VARCHAR(250),"+
		    "address1 VARCHAR(250),"+
		    "address2 VARCHAR(250),"+
		    "city VARCHAR(250),"+
		    "state VARCHAR(250),"+
		    "zip VARCHAR(250),"+
		    "country VARCHAR(250),"+
		    "credit_card_type VARCHAR(250),"+
		    "credit_card_number VARCHAR(250),"+
		    "credit_card_cvv VARCHAR(250),"+
		    "credit_card_expiry VARCHAR(250),"+
		    "PRIMARY KEY(userId) )";
		    
		    
		    //stmt.executeUpdate(zeUserTable);
		    //}// end of if database doesn't exist, create it
		   
		}catch ( ClassNotFoundException | SQLException e ) {
		    System.out.println("Driver problem: "+e);

		}finally{
			System.out.println("DONE!");
			if (conn != null){
				try{
					conn.close();
					stmt.close();
				}catch(SQLException ignore){
					// this doesn't mind..
				}
			}
		}
		
	}
	//}
}
