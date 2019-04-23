package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Reservation;
import fr.eni.ProjetJEE.dal.dao.ReservationDAO;

public class ReservationDAOJdbcImpl implements ReservationDAO {

	private static final String SELECT_ALL = "SELECT * from Reservation;";
	
	private static final String SELECT_BY_ID =	"SELECT * FROM Restaurant WHERE id=?;";
	
	private static final String INSERT_RESERVATION = "INSERT INTO RESERVATION(table,nom,tel,nbre_personnes) VALUES(?,?,?,?);";

	private static final String DELETE_RESERVATION = "DELETE FROM Reservation WHERE id=?";
	
	private static final String UPDATE_RESERVATION = "UPDATE Reservation set table=?, nom=?, tel=?, nbre_personnes=? WHERE id=?";
	
	@Override
	public void insert(Reservation reservation) throws BusinessException {
		if(reservation==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RESERVATION, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setInt(1, reservation.getTable());
			pstmt.setString(2, reservation.getNom());
			pstmt.setString(3, reservation.getTel());
			pstmt.setDouble(4, reservation.getNbrePersonne());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				reservation.setId(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_RESERVATION);
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
	public List<Reservation> selectAll() throws BusinessException {
		List<Reservation> restaurants = new ArrayList<Reservation>();
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
	public Reservation selectById(int id) throws BusinessException {
		Reservation result = null;
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
	public void update(Reservation reservation) throws BusinessException {
		if(reservation==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_RESERVATION);			
			pstmt.setInt(1, reservation.getTable());
			pstmt.setString(2, reservation.getNom());
			pstmt.setString(3, reservation.getTel());
			pstmt.setInt(4, reservation.getNbrePersonne());
			pstmt.setInt(5, reservation.getId());
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
	

	private Reservation map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		int tableId = rs.getInt("table_id");
		String nom = rs.getString("nom");
		String tel = rs.getString("tel");
		int nbrePersonnes = rs.getInt("nbre_personnes");
		
		return new Reservation(id,tableId,nom,tel,nbrePersonnes);
	}
}