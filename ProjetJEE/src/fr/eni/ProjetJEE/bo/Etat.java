package fr.eni.ProjetJEE.bo;

public class Etat {
	private int id;
	private String couleur;
	private String etat;
	
	public Etat() {
		super();
	}
	
	public Etat(String couleur, String etat) {
		super();
		this.couleur = couleur;
		this.etat = etat;
	}
	
	public Etat(int id, String couleur, String etat) {
		super();
		this.id = id;
		this.couleur = couleur;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
