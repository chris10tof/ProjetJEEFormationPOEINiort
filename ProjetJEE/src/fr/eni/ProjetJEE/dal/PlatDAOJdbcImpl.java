package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Categorie;
import fr.eni.ProjetJEE.bo.Plat;
import fr.eni.ProjetJEE.dal.dao.PlatDAO;

public class PlatDAOJdbcImpl implements PlatDAO {

	private static final String SELECT_ALL = "SELECT p.id,p.nom,description,prix,recette,uri_image,categorie_id,nbre_commande_totale,c.id as catId,c.nom as catNom FROM Plat p, Categorie c WHERE p.categorie_id=c.id;";	
	private static final String SELECT_BY_ID =	"SELECT p.id,p.nom,description,prix,recette,uri_image,categorie_id,c.id,c.nom FROM Plat p, Categorie c WHERE p.categorie_id=c.id; AND c.id=?";	
	private static final String INSERT_PLAT = "INSERT INTO PLAT(nom,description,prix,recette,uri_image,categorie_id,nbre_commande_totale) VALUES(?,?,?,?,?,?,?);";
	private static final String DELETE_PLAT = "DELETE FROM PLAT WHERE id=?";	
	private static final String UPDATE_PLAT = "UPDATE PLAT set nom=?,description=?,prix=?,recette=?,uri_image=?,categorie_id=?,nbre_commande_totale=?  WHERE id=?";
	
	@Override
	public void insert(Plat plat) throws BusinessException {
		if(plat==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_PLAT, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setString(1, plat.getNom());
			pstmt.setString(2, plat.getDescription());
			pstmt.setDouble(3, plat.getPrix());
			pstmt.setString(4, plat.getRecette());
			pstmt.setString(5, plat.getUriImage());
			pstmt.setInt(6, plat.getCategorie().getId());
			pstmt.setInt(4, plat.getNbrCommande());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				plat.setId(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_PLAT);
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
	public List<Plat> selectAll() throws BusinessException {
		List<Plat> personnes = new ArrayList<Plat>();
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
	public Plat selectById(int id) throws BusinessException {
		Plat result = null;
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
	public void update(Plat plat) throws BusinessException {
		if(plat==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_PLAT);			
			pstmt.setString(1, plat.getNom());
			pstmt.setString(2, plat.getDescription());
			pstmt.setDouble(3, plat.getPrix());
			pstmt.setString(4, plat.getRecette());
			pstmt.setString(5, plat.getUriImage());
			pstmt.setInt(6, plat.getCategorie().getId());
			pstmt.setInt(7, plat.getNbrCommande());
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

	private Plat map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		String nom = rs.getString("nom");
		String description = rs.getString("description");
		Double prix = rs.getDouble("prix");
		String recette = rs.getString("recette");
		String uriImage = rs.getString("uri_image");		
		Categorie categorieId = new Categorie();
		int catId = rs.getInt("catId");
		String catNom = rs.getString("catNom");		
		categorieId.setId(catId);
		categorieId.setNom(catNom);
		int nbrCommande = rs.getInt("nbre_commande_totale");
		
		Plat plat = new Plat(id, nom, description, prix, recette, uriImage, categorieId, nbrCommande);
		
		return plat;
	}
}