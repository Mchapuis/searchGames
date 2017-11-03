package org.soen387.a1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.soen387.bean.Game;

/**
 * Servlet implementation class Details
 */
@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_PATH = "/WEB-INF/details.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("id"));
		//String id = (String) session.getAttribute("param");
		String param = request.getParameter("param");
		Game game = new Game();
		@SuppressWarnings("unchecked")
		List<Game> gameList = (List<Game>) session.getAttribute("gameList");
		
		// find the id chosen by the user
		for(int i=0; i< gameList.size();i++){
			if(gameList.get(i).getId().equals(param)){// changed param to id
				game = gameList.get(i);
			}
		}
		// set the game chosen by the user for a full description
		session.setAttribute("game",game);
		//request.setAttribute("id",id);
		
		System.out.println("SESSION ID IS: " + session.getAttribute("param"));

		this.getServletContext().getRequestDispatcher(JSP_PATH).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
