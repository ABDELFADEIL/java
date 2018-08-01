package web;

import java.io.IOException;
import java.util.List;
import java.util.function.LongPredicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

// @WebServlet (name="cs", urlPatterns= {"*.php"})
public class ControleurServlet extends HttpServlet {
	private IProduitDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/index.php")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/chercher.php")) {
		    ProduitModel model = new ProduitModel();
			String motCle = request.getParameter("motCle");
		    model.setMotCle(motCle);
		    List<Produit> produits = metier.produitParMC(motCle);
		    model.setProduits(produits);
		    request.setAttribute("model", model);
			request.getRequestDispatcher("/produits.jsp").forward(request, response);
		}
		else if(path.equals("/Saisie.php")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);

		}
		else if(path.equals("/SaveProduit.php")&&(request.getMethod().equals("POST"))) {
			String designation= request.getParameter("designation");
			double prix= Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = metier.Save(new Produit(designation, prix, quantite));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("/Confirmation.jsp").forward(request, response);
		}
		else if(path.equals("/Supprime.php")) {
			Long id=Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			response.sendRedirect("/TP_CAT/chercher.php?motCle=");
		}
		else if(path.equals("/Edit.php")) {
			Long id=Long.parseLong(request.getParameter("id"));
            Produit p= metier.getProduit(id);
            request.setAttribute("produit", p);
			request.getRequestDispatcher("/EditProduit.jsp").forward(request, response);
		}
		else if(path.equals("/UpdateProduit.php")&&(request.getMethod().equals("POST"))) {
			Long id =Long.parseLong(request.getParameter("id"));
			String designation= request.getParameter("designation");
			double prix= Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = new Produit(designation, prix, quantite);
			p.setId(id);
			metier.update(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("/Confirmation.jsp").forward(request, response);
		}
		
		else {
			response.sendError(response.SC_NOT_FOUND);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);

	}

}
