package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Plat;

public interface PlatDAO {
	public void insert(Plat plat) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Plat plat) throws BusinessException;
	public List<Plat> selectAll() throws BusinessException;
	public Plat selectById(int id) throws BusinessException;
}
