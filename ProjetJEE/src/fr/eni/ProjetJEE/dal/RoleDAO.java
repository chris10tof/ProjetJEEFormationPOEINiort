package fr.eni.ProjetJEE.dal;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Role;

public interface RoleDAO{
	public void insert(Role role) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Role role) throws BusinessException;
	public List<Role> selectAll() throws BusinessException;
	public Role selectById(int id) throws BusinessException;
}
