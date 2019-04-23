package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Restaurant;

public interface RestaurantDAO {
	public void insert(Restaurant restaurant) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Restaurant role) throws BusinessException;
	public List<Restaurant> selectAll() throws BusinessException;
	public Restaurant selectById(int id) throws BusinessException;
}
