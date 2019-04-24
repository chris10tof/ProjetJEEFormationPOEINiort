package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Commentaire;
import fr.eni.ProjetJEE.dal.dao.CommentaireDAO;

public class CommentaireDAOJdbcImpl implements CommentaireDAO {

	private static final String SELECT_ALL = "SELECT * FROM Commentaire;";	
	private static final String SELECT_BY_ID =	"SELECT Commentaire WHERE id=?;";	
	private static final String INSERT_COMMENTAIRE = "INSERT INTO Commentaire(contenu,date,note) VALUES(?,?,?);";
	private static final String DELETE_COMMENTAIRE = "DELETE FROM Commentaire WHERE id=?";	
	private static final String UPDATE_COMMENTAIRE = "UPDATE Commentaire set contenu=?, date=?, note=? WHERE id=?";
	
	@Override
	public void insert(Commentaire commentaire) throws BusinessException {
		if(commentaire==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_COMMENTAIRE, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setString(1, commentaire.getContenu());
			pstmt.setDate(2, commentaire.getDate());
			pstmt.setDouble(3, commentaire.getNote());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				commentaire.setId(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_COMMENTAIRE);
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
	public List<Commentaire> selectAll() throws BusinessException {
		List<Commentaire> personnes = new ArrayList<Commentaire>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				personnes.add(map(rs));
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
		return personnes;
	}

	@Override
	public Commentaire selectById(int id) throws BusinessException {
		Commentaire result = null;
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
	public void update(Commentaire commentaire) throws BusinessException {
		if(commentaire==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_COMMENTAIRE);			
			pstmt.setString(1, commentaire.getContenu());
			pstmt.setDate(2, commentaire.getDate());
			pstmt.setDouble(3, commentaire.getNote());
			pstmt.setInt(4, commentaire.getId());
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

	private Commentaire map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		String contenu = rs.getString("contenu");
		Date date = rs.getDate("date");
		Double note = rs.getDouble("note");

		Commentaire commentaire = new Commentaire(id, contenu, date, note);
		
		return commentaire;
	}
}