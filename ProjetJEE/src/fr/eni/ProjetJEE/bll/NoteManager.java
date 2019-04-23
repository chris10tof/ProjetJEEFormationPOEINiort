package fr.eni.ProjetJEE.bll;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Role;
import fr.eni.ProjetJEE.dal.DAOFactory;
import fr.eni.ProjetJEE.dal.RoleDAO;

public class NoteManager {
	private RoleDAO noteDAO;
	
	public NoteManager() {
		noteDAO = DAOFactory.getRoleDAO();
	}
	
	public List<Role> selectionnerNotes() throws BusinessException
	{
		return noteDAO.selectAll();
	}

	public Role selectionnerNote(int idNote) throws BusinessException {
		return noteDAO.selectById(idNote);
	}

	public Role ajouterNote(String contenu) throws BusinessException{
		BusinessException businessException = new BusinessException();
		
		validerContenu(contenu, businessException);
		
		if(businessException.hasErreurs()) {
			throw businessException;
		}
		
		Role nouvelleNote = new Role(contenu);
		
		noteDAO.insert(nouvelleNote);
		
		return nouvelleNote;
	}

	public void supprimerNote(int idNote) throws BusinessException{
		noteDAO.delete(idNote);
	}
	
	public void updateNote(int idNote, String contenu) throws BusinessException {
		BusinessException businessException = new BusinessException();
		
		validerContenu(contenu, businessException);
		
		if(businessException.hasErreurs()) {
			throw businessException;
		}
		
		Role noteAModifier = new Role(idNote, contenu);
		noteDAO.update(noteAModifier);
		
	}
	
	private void validerContenu(String contenu, BusinessException businessException) {
		if(contenu==null || contenu.trim().length()>500)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_LISTE_NOM_ERREUR);
		}
	}

	

	
}
