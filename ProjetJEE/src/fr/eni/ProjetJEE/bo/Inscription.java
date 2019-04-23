package fr.eni.ProjetJEE.bo;

public class Inscription {
	private int id;
	private String commentaire;
	private Personne personne;
	private Restaurant restaurant;
	
	public Inscription() {
		super();
	}
	
	public Inscription(String commentaire, Personne personne, Restaurant restaurant) {
		super();
		this.commentaire = commentaire;
		this.personne = personne;
		this.restaurant = restaurant;
	}
	
	public Inscription(int id, String commentaire, Personne personne, Restaurant restaurant) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.personne = personne;
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
