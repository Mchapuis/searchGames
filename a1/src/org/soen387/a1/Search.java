package org.soen387.a1;
import org.soen387.bean.Game;
import org.soen387.bean.User;





import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String JSP_PATH = "/WEB-INF/search.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(JSP_PATH).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Get session to save content*/
		HttpSession session = request.getSession();
		
		/*Search Parse form results*/
		SearchParse searchResponse = new SearchParse();
		
		/*Get bean list*/
		List<Game> gameList = searchResponse.getGame(request);
		int sizeList = gameList.size();
		
		String badQuery = "There is no games with these keywords";
		String optionChosen = searchResponse.option;
		
		/*Set the list in the request*/
		if(sizeList > 0){
			session.setAttribute("gameList", gameList);
			session.setAttribute("optionChosen", optionChosen);

		}else{
			
			request.setAttribute("badQuery", badQuery);
			session.setAttribute("badQuery", badQuery);
		}
		
		/*Send object back to JSP to the searchResult page*/
		response.sendRedirect("/a1/searchResult");
		//this.getServletContext().getRequestDispatcher(JSP_PATH).forward(request,response);
		
	}

}
