package fr.eni.ProjetJEE.bo;

public class Table {
	private int id;
	private int restaurantId;
	private Etat etat;
	
	public Table() {
		super();
	}

	public Table(int restaurantId, Etat etat) {
		super();
		this.restaurantId = restaurantId;
		this.etat = etat;
	}

	public Table(int id, int restaurantId, Etat etat) {
		super();
		this.id = id;
		this.restaurantId = restaurantId;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
}
