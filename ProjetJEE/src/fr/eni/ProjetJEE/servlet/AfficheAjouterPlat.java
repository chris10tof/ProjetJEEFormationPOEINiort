package fr.eni.ProjetJEE.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Categorie;
import fr.eni.ProjetJEE.bo.Plat;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.dal.DAOFactory;
import fr.eni.ProjetJEE.dal.PlatDAOJdbcImpl;

/**
 * Servlet implementation class Listecat
 */
@WebServlet("/AjouterPlat")
public class AfficheAjouterPlat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Categorie> listeCategories = null;
		RequestDispatcher dispatcher = null;
		try {
			listeCategories = DAOFactory.getCategorieDAO().selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeCategories", listeCategories);
		dispatcher = request.getRequestDispatcher("/WEB-INF/views/ajouterPlat.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		String prix = request.getParameter("prix");
		String recette = request.getParameter("recette");
		String uriImage = request.getParameter("image");
		String categorie = request.getParameter("categorie");
		
		String[] parts = categorie.split("@");
		int categorie_id = Integer.parseInt(parts[0]);
		String categorie_nom = parts[1];

		Double prix1 = Double.parseDouble(prix);
		
		Categorie cat = new Categorie();		
		cat.setId(categorie_id);
		cat.setNom(categorie_nom);
		
		Plat plat = new Plat(nom,description,prix1,recette,uriImage,cat);
		
		PlatDAOJdbcImpl nouveauPlat = new PlatDAOJdbcImpl();
		try {
			nouveauPlat.insert(plat);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher = request.getRequestDispatcher("/WEB-INF/views/ajouterPlat.jsp");
		dispatcher.forward(request, response);
	}
}
