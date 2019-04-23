package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Inscription;

public interface InscriptionDAO {
	public void insert(Inscription inscription) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Inscription inscription) throws BusinessException;
	public List<Inscription> selectAll() throws BusinessException;
	public Inscription selectById(int id) throws BusinessException;
}
