package fr.eni.ProjetJEE.bo;

public class Categorie {
	private int idCategoriePlat;
	private String nom;

	public Categorie() {
		super();
	}

	public Categorie(int idCategoriePlat, String nom) {
		super();
		this.idCategoriePlat = idCategoriePlat;
		this.nom = nom;
	}

	public int getId() {
		return idCategoriePlat;
	}

	public void setId(int id) {
		this.idCategoriePlat = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	
}
