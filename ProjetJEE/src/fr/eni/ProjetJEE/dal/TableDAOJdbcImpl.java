package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Etat;
import fr.eni.ProjetJEE.bo.Personne;
import fr.eni.ProjetJEE.bo.Reservation;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.bo.Role;
import fr.eni.ProjetJEE.bo.Table;
import fr.eni.ProjetJEE.dal.dao.PersonneDAO;
import fr.eni.ProjetJEE.dal.dao.TableDAO;

public class TableDAOJdbcImpl implements TableDAO {

	private static final String SELECT_ALL = "SELECT t.id as id_table, t.etat_id,t.restaurant_id,"
						+ "e.id,e.couleur as etat_couleur,e.etat as etat_etat,"
						+ "r.id FROM [Table] t, Etat e, Restaurant r "
						+ "WHERE t.etat_id=e.id "
						+ "AND t.restaurant_id=r.id;";	
	private static final String SELECT_BY_ID =	"SELECT t.id as id_table, t.etat_id,t.restaurant_id,\"\r\n" + 
			"						+ \"e.id,e.couleur as etat_couleur,e.etat as etat_etat,\"\r\n" + 
			"						+ \"r.id FROM [Table] t, Etat e, Restaurant r \"\r\n" + 
			"						+ \"WHERE t.etat_id=e.id \"\r\n" + 
			"						+ \"AND t.restaurant_id=r.id AND t.id=?;";		
	private static final String UPDATE_TABLE = "UPDATE Table set etat_id=? WHERE id=?";

	@Override
	public List<Table> selectAll() throws BusinessException {
		List<Table> tables = new ArrayList<Table>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				tables.add(map(rs));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return tables;
	}

	@Override
	public Table selectById(int id) throws BusinessException {
		Table result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = map(rs);
			}
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}
		
		if(result == null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
		}
		
		return result;
	}
	
	@Override
	public void update(Table table) throws BusinessException {
		if(table==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_TABLE);			
			pstmt.setInt(1, table.getEtatId().getId());
			pstmt.setInt(2, table.getIdTable());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}	

	private Table map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id_table");
		
		Restaurant restaurant = new Restaurant();
		int idResto = rs.getInt("id");
		restaurant.setId(idResto);
		
		Etat etat = new Etat();
		int etatId = rs.getInt("etat_id");
		String etatCouleur = rs.getString("etat_couleur");
		String etatEtat = rs.getString("etat_etat");		
		etat.setId(etatId);
		etat.setCouleur(etatCouleur);
		etat.setEtat(etatEtat);
		
		return new Table(id, etat, restaurant);
	}

	@Override
	public void insert(Table table) throws BusinessException {
	
	}

	@Override
	public void delete(int id) throws BusinessException {

	}
}











