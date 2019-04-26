package fr.eni.ProjetJEE.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
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
import fr.eni.ProjetJEE.bo.Inscription;
import fr.eni.ProjetJEE.bo.Personne;
import fr.eni.ProjetJEE.bo.Plat;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.bo.Role;
import fr.eni.ProjetJEE.dal.DAOFactory;
import fr.eni.ProjetJEE.dal.InscriptionDAOJdbcImpl;
import fr.eni.ProjetJEE.dal.PersonneDAOJdbcImpl;
import fr.eni.ProjetJEE.dal.PlatDAOJdbcImpl;

/**
 * Servlet implementation class ListeRole
 */
@WebServlet("/Inscription")
public class AfficheInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurant> listeRestaurants = null;
		try {
			listeRestaurants = DAOFactory.getRestaurantDAO().selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeRestaurants", listeRestaurants);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/inscription.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String confMdp = request.getParameter("confMdp");
		String commentaire = request.getParameter("commentaire");
		String restaurant_infos = request.getParameter("restaurant");

		String[] restaurant_infos_ = restaurant_infos.split("@");
		int restaurant_id = Integer.parseInt(restaurant_infos_[0]);
		String restaurant_nom = restaurant_infos_[1];

//			PreparedStatement.RETURN_GENERATED_KEYS
		if(mdp.equals(confMdp)) {
			Role role = new Role(3, "Client");
			Restaurant restaurant = new Restaurant(restaurant_id, restaurant_nom);

			try {
				PersonneDAOJdbcImpl nouvellePersonne = new PersonneDAOJdbcImpl();
				Personne personne = new Personne(nom, prenom, email, mdp, "", role);
				nouvellePersonne.insert(personne);
				
				Inscription inscription = new Inscription(commentaire, personne, restaurant);
	
				InscriptionDAOJdbcImpl nouvelleInscription = new InscriptionDAOJdbcImpl();
			
				nouvelleInscription.insert(inscription);
			
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Accueil");
		dispatcher.forward(request, response);
	}

}
