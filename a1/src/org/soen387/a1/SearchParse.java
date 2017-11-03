package org.soen387.a1;

import org.soen387.bean.Game;




import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.bean.User;

import com.mysql.*;


/**
 * Servlet implementation class SearchParse
 */

public class SearchParse {

	public String[] userOption; 
	public String option; // to be shown on screen
	public SearchParse(){
	}
	
	/*
	 * 1- get the selected option value
	 * 2- get the user input
	 * 3- call database with the prepared statement
	 * 4- for each loop, create an object and add it to an array
	 * ---- the view will loop throught this array to create a small list of games
	 * 5- return an array of games
	 */
	public List<Game> getGame(HttpServletRequest request){
		
		// get the selected option value
		option = request.getParameter("optionValue");
		String input = request.getParameter("search");
		input = input.replace("'","");// need to remove this because of an error in specials.jsp
		String words[] = input.split(" ");
		
		
		List<Game> allGames = new ArrayList<Game>();
		Game game = new Game(); // basic init for later
		int position = game.getOption(option);// to get position in the results given back
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		
		// connect to database
		final String DB_URL = "jdbc:mysql://localhost:3306/a1_soen387";
		
		// Database user and password;
		final String USER = "root";
		final String PASSWORD = "";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try{
			// Register the driver
		    Class.forName(JDBC_DRIVER);
		    
		    // Open connection
		    conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		    
		    // ---using preparedStatement against XSS injection
		    System.out.println("WHAT IS THAT: "+words[0]);
		    
		    // if user choose a particular column
		    
		    // THIS IS TO RECORD THE WHOLE OBJECT
		    System.out.println("option is: "+option+" and word is "+ words[0]);
		    String findInColumn = "SELECT * "
			    		+ "FROM gameData WHERE "+option+" LIKE ? ";
		    
		   
		    System.out.println(findInColumn);

		    // add keywords until no more...
		    // for now only one
		    int i = 1;
		    while(i < words.length ){
		    	System.out.println("words "+words[i]);
			   findInColumn = findInColumn + " OR "+option+" LIKE ? ";
			   i++;
		    }
		    
		    // prepare statement
		    prepStmt = conn.prepareStatement(findInColumn);
		    prepStmt.setString(1, "%"+ words[0]+"%");// starts at 1 here ----
		    
		    i = 1;
		    while(i < words.length){
		    	System.out.println("word : "+words[i]);
		    	prepStmt.setString((i+1), "%"+words[i]+"%");// setString starts at 1, so need to increment
		    	i++;
		    }
		    
		    String tosee = prepStmt.toString();
		    System.out.println("Query after prep is "+ tosee);
		    // executeQuery
		    ResultSet list= prepStmt.executeQuery();
		    System.out.println("LIST :"+ list.getFetchSize());
		    // get the game form database and save it in an object bean
		    
		    
		    ResultSetMetaData metadata = list.getMetaData();
		    int numberOfColumns = metadata.getColumnCount();
		    System.out.println("number of columns "+numberOfColumns);
		    int k;
		    while(list.next()){
		    	System.out.println("reset k");
		    	k=1;
		    	System.out.println("k is now "+ k);
		    	// go throught each column and set string
		    	while(k <= numberOfColumns){
		    		System.out.println("still in the loop? k is "+k);
		    		game.setId( list.getString(k++) );
			    	game.setGameTitle( list.getString(k++) );
			    	System.out.println("Searched title is: "+ game.getGameTitle());
			    	game.setReleaseDate( list.getString(k++) );
			    	game.setPlatform( list.getString(k++) );
			    	game.setOverview(  list.getString(k++));
			    	game.setNum_players( list.getString(k++) );
			    	game.setCoop( list.getString(k++));
			    	game.setGenre( list.getString(k++) );
			    	game.setDeveloper( list.getString(k++) );
			    	game.setPublisher( list.getString(k++) );
			    	game.setFront_box_art( list.getString(k++) );
			    	game.setBack_box_art( list.getString(k++) );
			    	game.setLogo( list.getString(k++) );
			    	game.setDeveloper_logo( list.getString(k++) );
			    	k++;
			    	System.out.println("k is at "+ k+ "And the game is "+ game.getGameTitle());
		    	}
		    
		    	// add game to array
		    	allGames.add(game);
		    	
		    	//reset for next loop
		    	game = new Game();
		    }
		}catch(ClassNotFoundException | SQLException e){
			System.out.println("SearchParse.java error.."+e);
		}
		
		return allGames;
	}
}
