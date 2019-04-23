package fr.eni.ProjetJEE.dal;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.AssociationCommentaire;

public interface AssociationCommentaireDAO {
	public void insert(AssociationCommentaire assoCom) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(AssociationCommentaire AssoCom) throws BusinessException;
	public List<AssociationCommentaire> selectAll() throws BusinessException;
	public AssociationCommentaire selectById(int id) throws BusinessException;
}
