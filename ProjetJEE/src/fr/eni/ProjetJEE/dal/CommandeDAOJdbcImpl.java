package fr.eni.ProjetJEE.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.AssociationCommentaire;
import fr.eni.ProjetJEE.bo.Commande;
import fr.eni.ProjetJEE.bo.Plat;
import fr.eni.ProjetJEE.bo.Table;
import fr.eni.ProjetJEE.dal.dao.CommandeDAO;

public class CommandeDAOJdbcImpl implements CommandeDAO {

	private static final String SELECT_ALL = "SELECT c.id,\r\n" + 
			"		t.id as id_table,\r\n" + 
			"		pl.nom,\r\n" + 
			"		c.nbre_plat as nomPlat\r\n" + 
			"		FROM [Commande] c,[Plat] pl, [Table] t\r\n" + 
			"		WHERE c.table_id=t.id AND c.plat_Id=pl.id;";	
	private static final String SELECT_BY_ID =	"SELECT c.id,\r\n" + 
			"		t.id as id_table,\r\n" + 
			"		pl.nom as nomPlat,\r\n" + 
			"		c.nbre_plat\r\n" + 
			"		FROM [Commande] c,[Plat] pl, [Table] t\r\n" + 
			"		WHERE c.table_id=t.id AND c.plat_Id=pl.id AND c.id=?;";	
	private static final String INSERT_COMMANDE = "INSERT INTO Commande(table_id,plat_id,nbre_plat) VALUES(?,?,?);";
	private static final String DELETE_COMMANDE = "DELETE FROM Commande WHERE id=?";	
	private static final String UPDATE_COMMANDE = "UPDATE Commande set table_id=?,plat_id=?,nbre_plat=? WHERE id=?";
	
	@Override
	public void insert(Commande commande) throws BusinessException {
		if(commande==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_COMMANDE, PreparedStatement.RETURN_GENERATED_KEYS);			
			pstmt.setInt(1, commande.getTableId().getIdTable());
			pstmt.setInt(2, commande.getPlatId().getId());
			pstmt.setDouble(3, commande.getNbrePlat());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				commande.setIdCommande(rs.getInt(1));
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
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_COMMANDE);
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
	public List<Commande> selectAll() throws BusinessException {
		List<Commande> commande = new ArrayList<Commande>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				commande.add(map(rs));
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
		return commande;
	}

	@Override
	public Commande selectById(int id) throws BusinessException {
		Commande result = null;
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
	
	private Commande map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		
		Table tableId = new Table();
		int idTable = rs.getInt("id_table");
		tableId.setIdTable(idTable);
		
		Plat platId = new Plat();
		String nomPlat = rs.getString("nomPLat");
		platId.setNom(nomPlat);
		
		Double nbrePlat = rs.getDouble("nbre_plat");
		
		return new Commande(tableId,platId,nbrePlat);
	}

	@Override
	public void update(Commande commande) throws BusinessException {
		if(commande==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_COMMANDE);			
			pstmt.setInt(1, commande.getTableId().getIdTable());
			pstmt.setInt(2, commande.getPlatId().getId());
			pstmt.setDouble(3, commande.getNbrePlat());
			pstmt.setInt(4, commande.getIdCommande());
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
}