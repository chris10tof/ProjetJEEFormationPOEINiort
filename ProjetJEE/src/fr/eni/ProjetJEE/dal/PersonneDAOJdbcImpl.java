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

public class PersonneDAOJdbcImpl implements PersonneDAO {

	private static final String SELECT_ALL = "SELECT p.id, p.Nom, Prenom, email, mdp, uri_avatar, r.id AS role_id, r.nom AS role_nom FROM Personne p, Role r WHERE p.role_id=r.id;";
	
	private static final String SELECT_BY_ID =	"SELECT p.id, p.Nom, Prenom, email, mdp, uri_avatar, r.id AS role_id, r.nom AS role_nom FROM Personne p, Role r WHERE p.role_id=r.id AND r.id=?;";
	
	private static final String INSERT_PERSONNE = "INSERT INTO Personne(nom, prenom, email, mdp, uri_avatar, role_id) VALUES(?,?,?,?,?,?);";

	private static final String DELETE_PERSONNE = "DELETE FROM Personne WHERE id=?";
	
	private static final String UPDATE_PERSONNE = "UPDATE Personne SET nom=? WHERE id=?";
	
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

	public static Personne checkUser(String email, String mdp) throws SQLException {
		Connection conn = null;

		String sql = "SELECT p.id, p.Nom, Prenom, email, mdp, uri_avatar, r.id AS role_id, r.nom AS role_nom FROM [Personne] p LEFT JOIN [Role] r ON p.role_id = r.id WHERE email=? and mdp=?";
		Personne personne = null;

		conn = ConnectionProvider.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, email);
        pstm.setString(2, mdp);
        ResultSet rs =pstm.executeQuery();

        if(rs.next()) {
    		Role role = new Role();
    		int roleId = rs.getInt("role_id");
    		String roleName = rs.getString("role_nom");

    		role.setId(roleId);
    		role.setNom(roleName);

        	personne = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("mdp"), rs.getString("uri_avatar"), role);
        }

        return personne;
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
