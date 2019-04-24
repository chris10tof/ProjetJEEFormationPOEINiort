package fr.eni.ProjetJEE.bo;

public class Table {
	
	private int idTable;
	private int reservationId;
	private Etat etatId;
	private Restaurant restaurantId;	
	
	public Table() {
		super();
	}
	
	public Table(int reservationId, Etat etatId, Restaurant restaurantId) {
		super();
		this.reservationId = reservationId;
		this.etatId = etatId;
		this.restaurantId = restaurantId;
	}

	public Table(int idTable, int reservationId, Etat etatId, Restaurant restaurantId) {
		super();
		this.idTable = idTable;
		this.reservationId = reservationId;
		this.etatId = etatId;
		this.restaurantId = restaurantId;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
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
