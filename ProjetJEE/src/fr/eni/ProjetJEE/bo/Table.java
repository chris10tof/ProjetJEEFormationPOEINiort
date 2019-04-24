package fr.eni.ProjetJEE.bo;

public class Table {
	
	private int idTable;
	private Etat etatId;
	private Restaurant restaurantId;	
	
	public Table() {
		super();
	}
	
	public Table(Etat etatId, Restaurant restaurantId) {
		super();
		this.etatId = etatId;
		this.restaurantId = restaurantId;
	}

	public Table(int idTable, Etat etatId, Restaurant restaurantId) {
		super();
		this.idTable = idTable;
		this.etatId = etatId;
		this.restaurantId = restaurantId;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public Etat getEtatId() {
		return etatId;
	}

	public void setEtatId(Etat etatId) {
		this.etatId = etatId;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}	
}
