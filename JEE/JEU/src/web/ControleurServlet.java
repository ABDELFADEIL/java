package web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.MetierJeu;
import metier.ModelJeu;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	private MetierJeu  metier;    
  
	
	public void init(ServletConfig config) throws ServletException {
		metier = new MetierJeu();
		metier.genererSecret();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("VueJeu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// doGet(request, response);
		HttpSession session = request.getSession();
		ModelJeu mod;
		if(session.getAttribute("model")==null) {
			mod = new ModelJeu();
			session.setAttribute("model", mod);

		} else {
			mod =(ModelJeu) session.getAttribute("model");
		}
		int nb = Integer.parseInt(request.getParameter("nombre"));
		mod.setNombre(nb);
		String res= metier.Jouer(nb);
		mod.getHistorique().add(res);
		request.getRequestDispatcher("VueJeu.jsp").forward(request, response);

	}

}
