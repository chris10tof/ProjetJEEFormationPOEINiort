package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.AssociationCommentaire;
import fr.eni.ProjetJEE.bo.Commentaire;
import fr.eni.ProjetJEE.bo.Personne;
import fr.eni.ProjetJEE.bo.Plat;
import fr.eni.ProjetJEE.bo.Restaurant;
import fr.eni.ProjetJEE.dal.dao.AssociationCommentaireDAO;

public class AssociationCommentaireDAOJdbcImpl implements AssociationCommentaireDAO {

	private static final String SELECT_ALL = "SELECT a.id,\r\n" + 
			"		p.nom, p.prenom,\r\n" + 
			"		pl.nom as nomPlat,\r\n" + 
			"		r.localisation,\r\n" + 
			"		c.contenu, c.date, c.note\r\n" + 
			"		FROM [AssociationCommentaire] a, [Personne] p, [Plat] pl, [Restaurant] r, [Commentaire] c\r\n" + 
			"		WHERE a.personne_id=p.id \r\n" + 
			"		AND a.plat_id=pl.id \r\n" + 
			"		AND a.restaurant_id=r.id \r\n" + 
			"		AND a.commentaire_id=c.id;";	
	private static final String SELECT_BY_ID =	"SELECT a.id,\r\n" + 
			"		p.nom, p.prenom,\r\n" + 
			"		pl.nom as nomPlat,\r\n" + 
			"		r.localisation,\r\n" + 
			"		c.contenu, c.date, c.note\r\n" + 
			"		FROM [AssociationCommentaire] a, [Personne] p, [Plat] pl, [Restaurant] r, [Commentaire] c\r\n" + 
			"		WHERE a.personne_id=p.id \r\n" + 
			"		AND a.plat_id=pl.id \r\n" + 
			"		AND a.restaurant_id=r.id \r\n" + 
			"		AND a.commentaire_id=c.id AND a.id=?;";	
	private static final String INSERT_ASSOCOMM = "INSERT INTO AssociationCommentaire(personne_id,plat_id,restaurant_id;commentaire_id) VALUES(?,?,?,?);";
	private static final String DELETE_ASSOCOMM = "DELETE FROM AssociationCommentaire WHERE id=?";	
	
	@Override
	public void insert(AssociationCommentaire associationCommentaire) throws BusinessException {
		if(associationCommentaire==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ASSOCOMM, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setInt(1, associationCommentaire.getPersonneId().getId());
			pstmt.setInt(2, associationCommentaire.getPlatId().getId());
			pstmt.setInt(3, associationCommentaire.getRestaurantId().getId());
			pstmt.setInt(4, associationCommentaire.getCommentaireId().getId());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				associationCommentaire.setIdAssociation(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_ASSOCOMM);
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
	public List<AssociationCommentaire> selectAll() throws BusinessException {
		List<AssociationCommentaire> associationCommentaire = new ArrayList<AssociationCommentaire>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				associationCommentaire.add(map(rs));
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
		return associationCommentaire;
	}

	@Override
	public AssociationCommentaire selectById(int id) throws BusinessException {
		AssociationCommentaire result = null;
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
	
	private AssociationCommentaire map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		
		Personne personneId = new Personne();
		String nomPersonne = rs.getString("nom");
		String prenomPersonne = rs.getString("prenom");
		personneId.setNom(nomPersonne);
		personneId.setPrenom(prenomPersonne);
		
		Plat platId = new Plat();
		String nomPlat = rs.getString("nomPLat");
		platId.setNom(nomPlat);
		
		Restaurant restaurantId = new Restaurant();
		String nomRestaurant = rs.getString("localisation");
		restaurantId.setLocalisation(nomRestaurant);
		
		Commentaire commentaireId = new Commentaire();
		String contenu = rs.getString("contenu");
		Date date = rs.getDate("date");
		Double note = rs.getDouble("note");
		commentaireId.setContenu(contenu);
		commentaireId.setDate(date);
		commentaireId.setNote(note);

		AssociationCommentaire associationCommentaire = new AssociationCommentaire(id,personneId, platId, restaurantId, commentaireId);
		
		return associationCommentaire;
	}

	@Override
	public void update(AssociationCommentaire AssoCom) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
}