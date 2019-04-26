package fr.eni.ProjetJEE.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Personne;
import fr.eni.ProjetJEE.bo.Role;
import fr.eni.ProjetJEE.dal.PersonneDAOJdbcImpl;
import fr.eni.ProjetJEE.dal.dao.PersonneDAO;

/**
 * Servlet implementation class ListeRole
 */
@WebServlet("/Connexion")
public class AfficheConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/connexion.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		int i = 0;

		PersonneDAO pdao = new PersonneDAOJdbcImpl();
		try {
			Personne personne = PersonneDAOJdbcImpl.checkUser(email, mdp);
			if (personne != null) {
				HttpSession session = request.getSession();
				session.setAttribute("id", personne.getId());
				session.setAttribute("nom", personne.getNom());
				session.setAttribute("prenom", personne.getPrenom());
				session.setAttribute("mail", personne.getEmail());
				session.setAttribute("mdp", personne.getMdp());
				session.setAttribute("uri_avatar", personne.getUriAvatar());
				session.setAttribute("role", personne.getRole().getNom());

				RequestDispatcher rd = request.getRequestDispatcher("/Accueil");
				rd.forward(request, response);
			} else {
				if(i == 3) {
					i = 1;
					RequestDispatcher rd = request.getRequestDispatcher("/Inscription");
					rd.forward(request, response);
				} else if(i < 3) {
					i++;
					request.setAttribute("erreurPassword", "Identifiant ou mot de passe incorrect");
					RequestDispatcher rd = request.getRequestDispatcher("connexion");
					rd.forward(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
