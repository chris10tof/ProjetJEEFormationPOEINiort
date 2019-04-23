package fr.eni.ProjetJEE.dal;

import fr.eni.ProjetJEE.dal.dao.CategorieDAO;
import fr.eni.ProjetJEE.dal.dao.CommandeDAO;
import fr.eni.ProjetJEE.dal.dao.CommentaireDAO;
import fr.eni.ProjetJEE.dal.dao.EtatDAO;
import fr.eni.ProjetJEE.dal.dao.InscriptionDAO;
import fr.eni.ProjetJEE.dal.dao.PersonneDAO;
import fr.eni.ProjetJEE.dal.dao.PlatDAO;
import fr.eni.ProjetJEE.dal.dao.ReservationDAO;
import fr.eni.ProjetJEE.dal.dao.RestaurantDAO;
import fr.eni.ProjetJEE.dal.dao.RoleDAO;
import fr.eni.ProjetJEE.dal.dao.TableDAO;

public abstract class DAOFactory {

	public static AssociationCommenataireDAO getAssociationCommenataireDAO() {
		return new AssociationCommenataireDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	
	public static CommandeDAO getCommandeDAO() {
		return new CommandeDAOJdbcImpl();
	}
	
	public static CommentaireDAO getCommentaireDAO() {
		return new CommentaireDAOJdbcImpl();
	}
	
	public static EtatDAO getEtatDAO() {
		return new EtatDAOJdbcImpl();
	}
	
	public static InscriptionDAO getInscriptionDAO() {
		return new InscriptionDAOJdbcImpl();
	}
	
	public static PlatDAO getPlatDAO() {
		return new PlatDAOJdbcImpl();
	}
	
	public static PersonneDAO getPersonneDAO() {
		return new PersonneDAOJdbcImpl();
	}
	
	public static ReservationDAO getReservationDAO() {
		return new ReservationDAOJdbcImpl();
	}
	
	public static RestaurantDAO getRestaurantDAO() {
		return new RestaurantDAOJdbcImpl();
	}
	
	public static RoleDAO getRoleDAO() {
		return new RoleDAOJdbcImpl();
	}
	
	public static TableDAO getTableDAO() {
		return new TableDAOJdbcImpl();
	}
}
	