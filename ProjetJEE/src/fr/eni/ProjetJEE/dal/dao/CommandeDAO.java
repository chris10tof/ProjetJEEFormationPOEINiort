package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Commande;

public interface CommandeDAO {
	public void insert(Commande commande) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Commande commande) throws BusinessException;
	public List<Commande> selectAll() throws BusinessException;
	public Commande selectById(int id) throws BusinessException;
}
