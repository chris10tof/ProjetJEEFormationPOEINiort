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
import fr.eni.ProjetJEE.bo.Table;
import fr.eni.ProjetJEE.dal.DAOFactory;

/**
 * Servlet implementation class ListeRole
 */
@WebServlet("/ListeTable")
public class ListeTable extends HttpServlet {
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
		RequestDispatcher dispatcher = null;
		List<Table> listeTables = null;
		
		listeTables = DAOFactory.getTableDAO().selectAll();
		request.getSession().setAttribute("listeTables", listeTables);			
		dispatcher = request.getRequestDispatcher("/WEB-INF/listeTables.jsp"); 
		dispatcher.forward(request, response);		
	}
}
