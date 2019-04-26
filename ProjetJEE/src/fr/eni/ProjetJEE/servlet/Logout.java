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
import javax.servlet.http.HttpSession;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.dal.DAOFactory;

/**
 * Servlet implementation class ListeRole
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		session.invalidate();		// 
		
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
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/Accueil");
		dispatcher.forward(request, response);
	}

}
