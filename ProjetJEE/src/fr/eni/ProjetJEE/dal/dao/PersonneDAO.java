package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Personne;

public interface PersonneDAO {
	public void insert(Personne personne) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Personne personne) throws BusinessException;
	public List<Personne> selectAll() throws BusinessException;
	public Personne selectById(int id) throws BusinessException;
}
