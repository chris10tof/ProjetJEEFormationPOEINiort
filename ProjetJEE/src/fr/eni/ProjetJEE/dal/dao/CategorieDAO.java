package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Categorie;

public interface CategorieDAO {
	public void insert(Categorie categorie) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Categorie categorie) throws BusinessException;
	public List<Categorie> selectAll() throws BusinessException;
	public Categorie selectById(int id) throws BusinessException;
}
