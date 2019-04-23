package fr.eni.ProjetJEE.dal;

public abstract class DAOFactory {
	
	public static RoleDAO getRoleDAO()
	{
		return new RoleDAOJdbcImpl();
	}
}
	