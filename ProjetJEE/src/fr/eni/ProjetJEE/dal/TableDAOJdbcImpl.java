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

	private static final String SELECT_ALL = "SELECT t.id, t.etat_id,t.restaurant_id,e.id,e.couleur,e.etat,r.id,r.localisation,r.nbre_table,r.uri_resto,r.localisation_x,r.localisation_y FROM [Table] t, Etat e, Restaurant r WHERE t.etat_id=e.id AND t.restaurant_id=r.id;";	
	private static final String SELECT_BY_ID =	"SELECT t.id, t.etat_id,t.restaurant_id,e.id,e.couleur,e.etat,r.id,r.localisation,r.nbre_table,r.uri_resto,r.localisation_x,r.localisation_y FROM [Table] t, Etat e, Restaurant r WHERE t.etat_id=e.id AND t.restaurant_id=r.id AND t.id=?;";		
	private static final String UPDATE_TABLE = "UPDATE Table set reservation_id=?, etat_id=? WHERE id=?";

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
			pstmt.setInt(1, table.getReservationId());
			pstmt.setInt(2, table.getEtatId().getId());
			pstmt.setInt(3, table.getIdTable());
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
		
		int id = rs.getInt("id");
		int reservationId = rs.getInt("reservation_id");
		
		Restaurant restaurant = new Restaurant();
		int idResto = rs.getInt("id");
		String localisation = rs.getString("localisation");
		int nbreTable = rs.getInt("nbre_table");
		String uriResto = rs.getString("uri_resto");
		Double localisationX = rs.getDouble("localisation_Y");
		Double localisationY = rs.getDouble("localisation_Y");
		restaurant.setId(idResto);
		restaurant.setLocalisation(localisation);
		restaurant.setNbretable(nbreTable);
		restaurant.setUriResto(uriResto);
		restaurant.setLocalisationX(localisationX);
		restaurant.setLocalisationY(localisationY);
		
		Etat etat = new Etat();
		int etatId = rs.getInt("etat_id");
		String etatCouleur = rs.getString("etat_couleur");
		String etatEtat = rs.getString("etat_etat");		
		etat.setId(etatId);
		etat.setCouleur(etatCouleur);
		etat.setEtat(etatEtat);
		
		return new Table(id, reservationId, etat, restaurant);
	}

	@Override
	public void insert(Table table) throws BusinessException {
	
	}

	@Override
	public void delete(int id) throws BusinessException {

	}
}











