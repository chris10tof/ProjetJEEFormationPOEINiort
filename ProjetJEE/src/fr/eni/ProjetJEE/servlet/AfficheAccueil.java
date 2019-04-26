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
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.dal.DAOFactory;

/**
 * Servlet implementation class ListeRole
 */
@WebServlet("/Accueil")
public class AfficheAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			processRequest(request, response);
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, BusinessException, SQLException {
		List<Restaurant> listeRestaurants = null;
		RequestDispatcher dispatcher = null;
		listeRestaurants = DAOFactory.getRestaurantDAO().selectAll();
		request.setAttribute("listeRestaurants", listeRestaurants);
		dispatcher = request.getRequestDispatcher("/WEB-INF/views/accueil.jsp");
		dispatcher.forward(request, response);
	}

}
