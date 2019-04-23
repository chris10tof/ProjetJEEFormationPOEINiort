package fr.eni.ProjetJEE.dal.dao;

import java.util.List;

import fr.eni.ProjetJEE.BusinessException;
import fr.eni.ProjetJEE.bo.Reservation;

public interface ReservationDAO {
	public void insert(Reservation reservation) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Reservation reservation) throws BusinessException;
	public List<Reservation> selectAll() throws BusinessException;
	public Reservation selectById(int id) throws BusinessException;
}
