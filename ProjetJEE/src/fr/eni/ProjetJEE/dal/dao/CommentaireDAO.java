package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Commentaire;

public interface CommentaireDAO {
	public void insert(Commentaire commentaire) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Commentaire commentaire) throws BusinessException;
	public List<Commentaire> selectAll() throws BusinessException;
	public Commentaire selectById(int id) throws BusinessException;
}
