package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Inscription;
import fr.eni.ProjetJEE.bo.Personne;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.dal.dao.InscriptionDAO;

public class InscriptionDAOJdbcImpl implements InscriptionDAO {

	private static final String SELECT_ALL = "SELECT i.id, i.commentaire, \r\n" + 
			"		p.nom, p.prenom,\r\n" + 
			"		ra.localisation\r\n" + 
			"		FROM [Inscription] i, [Personne] p, [Restaurant] ra\r\n" + 
			"		WHERE i.personne_id=p.id AND i.restaurant_id=ra.id;";	
	private static final String SELECT_BY_ID =	"SELECT i.id, i.commentaire, \r\n" + 
			"		p.nom, p.prenom,\r\n" + 
			"		ra.localisation\r\n" + 
			"		FROM [Inscription] i, [Personne] p, [Restaurant] ra\r\n" + 
			"		WHERE i.personne_id=p.id AND i.restaurant_id=ra.id AND i.id=?;";	
	private static final String INSERT_INSCRIPTION = "INSERT INTO Inscription(commentaire,personne_id,restaurant_id) VALUES(?,?,?);";
	private static final String DELETE_INSCRIPTION = "DELETE FROM Inscription WHERE id=?";	
	private static final String UPDATE_INSCRIPTION = "UPDATE Inscription set commentaire=?, personne_id=?, restaurant_id=? WHERE id=?";
	
	@Override
	public void insert(Inscription inscription) throws BusinessException {
		if(inscription==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_INSCRIPTION, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setString(1, inscription.getCommentaire());
			pstmt.setInt(2, inscription.getPersonne().getId());
			pstmt.setInt(3, inscription.getRestaurant().getId());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				inscription.setId(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_INSCRIPTION);
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
	public List<Inscription> selectAll() throws BusinessException {
		List<Inscription> inscriptions = new ArrayList<Inscription>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				inscriptions.add(map(rs));
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
		return inscriptions;
	}

	@Override
	public Inscription selectById(int id) throws BusinessException {
		Inscription result = null;
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
	public void update(Inscription inscription) throws BusinessException {
		if(inscription==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_INSCRIPTION);			
			pstmt.setString(1, inscription.getCommentaire());
			pstmt.setInt(2, inscription.getPersonne().getId());
			pstmt.setInt(3, inscription.getRestaurant().getId());
			pstmt.setInt(4, inscription.getId());
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
	

	private Inscription map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id_inscription");
		String commentaire = rs.getString("commentaire");
		
		Personne personne = new Personne();
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");	

		personne.setNom(nom);
		personne.setPrenom(prenom);
		
		Restaurant restaurant = new Restaurant();
		String localisation = rs.getString("localisation");
		restaurant.setLocalisation(localisation);
		
		return new Inscription(id,commentaire,personne,restaurant);
	}
}