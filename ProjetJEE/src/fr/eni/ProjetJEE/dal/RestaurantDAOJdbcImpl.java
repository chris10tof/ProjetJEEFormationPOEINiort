package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.dal.dao.RestaurantDAO;

public class RestaurantDAOJdbcImpl implements RestaurantDAO {

	private static final String SELECT_ALL = "SELECT * from Restaurant;";
	
	private static final String SELECT_BY_ID =	"SELECT * FROM Restaurant WHERE id=?;";
	
	private static final String INSERT_RESTAURANT = "INSERT INTO RESTAURANT(localisation,nbre_table,uri_resto) VALUES(?,?,?);";

	private static final String DELETE_RESTAURANT = "DELETE FROM Restaurant WHERE id=?";
	
	private static final String UPDATE_RESTAURANT = "UPDATE Restaurant set localisation=?, nbre_table=?, uri_resto=? WHERE id=?";
	
	@Override
	public void insert(Restaurant restaurant) throws BusinessException {
		if(restaurant==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RESTAURANT, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setString(1, restaurant.getLocalisation());
			pstmt.setInt(2, restaurant.getNbretable());
			pstmt.setString(3, restaurant.getUriResto());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				restaurant.setId(rs.getInt(1));
			}
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

	@Override
	public void delete(int id) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_RESTAURANT);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
			throw businessException;
		}
		
	}

	@Override
	public List<Restaurant> selectAll() throws BusinessException {
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				restaurants.add(map(rs));
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
		return restaurants;
	}

	@Override
	public Restaurant selectById(int id) throws BusinessException {
		Restaurant result = null;
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
	public void update(Restaurant restaurant) throws BusinessException {
		if(restaurant==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_RESTAURANT);			
			pstmt.setString(1, restaurant.getLocalisation());
			pstmt.setInt(2, restaurant.getNbretable());
			pstmt.setString(3, restaurant.getUriResto());
			pstmt.setInt(4, restaurant.getId());
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
	

	private Restaurant map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		String localisation = rs.getString("localisation");
		int nbreTable = rs.getInt("nbre_table");
		String uriResto = rs.getString("uri_resto");
		
		return new Restaurant(id,localisation,nbreTable,uriResto);
	}
}











