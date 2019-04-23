package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Personne;
import fr.eni.ProjetJEE.bo.Role;
import fr.eni.ProjetJEE.dal.dao.PersonneDAO;

public class TableDAOJdbcImpl implements PersonneDAO {

	private static final String SELECT_ALL = "select p.id, p.Nom, Prenom, email, mdp, uri_avatar, r.id as role_id, r.nom as role_nom from Personne p, Role r where p.role_id=r.id;";
	
	private static final String SELECT_BY_ID =	"select p.id, p.Nom, Prenom, email, mdp, uri_avatar, r.id as role_id, r.nom as role_nom from Personne p, Role r where p.role_id=r.id and r.id=?;";
	
	private static final String INSERT_TABLE = "INSERT INTO Table(nom,prenom,email,mdp,uri_avatar,role_id) VALUES(?,?,?,?,?,?,?);";

	private static final String DELETE_TABLE = "DELETE FROM Table WHERE id=?";
	
	private static final String UPDATE_TABLE = "UPDATE Table set nom=? WHERE id=?";
	
	@Override
	public void insert(Personne personne) throws BusinessException {
		if(personne==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_PERSONNE, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setString(1, personne.getNom());
			pstmt.setString(2, personne.getPrenom());
			pstmt.setString(3, personne.getEmail());
			pstmt.setString(4, personne.getMdp());
			pstmt.setString(5, personne.getUriAvatar());
			pstmt.setInt(6, personne.getRole().getId());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				personne.setId(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_PERSONNE);
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
	public List<Personne> selectAll() throws BusinessException {
		List<Personne> personnes = new ArrayList<Personne>();
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
	public Personne selectById(int id) throws BusinessException {
		Personne result = null;
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
	public void update(Personne personne) throws BusinessException {
		if(personne==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_PERSONNE);			
			pstmt.setString(1, personne.getNom());
			pstmt.setString(2, personne.getPrenom());
			pstmt.setString(3, personne.getEmail());
			pstmt.setString(4, personne.getMdp());
			pstmt.setString(5, personne.getUriAvatar());
			pstmt.setInt(6, personne.getRole().getId());
			pstmt.setInt(7, personne.getId());
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
	

	private Personne map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String mdp = rs.getString("mdp");
		String uriAvatar = rs.getString("uri_avatar");
		
		Role role = new Role();
		int roleId = rs.getInt("role_id");
		String roleName = rs.getString("role_nom");
		
		role.setId(roleId);
		role.setNom(roleName);
		Personne personne = new Personne(id, nom, prenom, email, mdp, uriAvatar, role);
		
		return personne;
	}
}











