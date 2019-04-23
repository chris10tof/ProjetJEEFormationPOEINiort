package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Etat;

public interface EtatDAO {
	public void insert(Etat etat) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Etat etat) throws BusinessException;
	public List<Etat> selectAll() throws BusinessException;
	public Etat selectById(int id) throws BusinessException;
}
