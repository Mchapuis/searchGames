package org.soen387.a1;

import org.soen387.bean.Game;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class specials
 */
@WebServlet("/specials")
public class specials extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String JSP_PATH = "/WEB-INF/specials.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public specials() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println(request.getParameter("optionValue") + " and the other is "+ request.getParameter("search"));
		
		SearchParse searchResponse = new SearchParse();
		
		List<Game> gameList = searchResponse.getGame(request);
		
		request.setAttribute("gameList", gameList);
		
		
		this.getServletContext().getRequestDispatcher(JSP_PATH).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
