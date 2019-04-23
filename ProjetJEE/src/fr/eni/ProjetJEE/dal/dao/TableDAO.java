package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Table;

public interface TableDAO {
	public void insert(Table table) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Table table) throws BusinessException;
	public List<Table> selectAll() throws BusinessException;
	public Table selectById(int id) throws BusinessException;
}
