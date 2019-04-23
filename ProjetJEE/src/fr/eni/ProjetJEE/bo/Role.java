package fr.eni.ProjetJEE.bo;

public class Role {
	private int id;
	private String nom;
	
	public Role() {
		super();
	}

	public Role(String nom) {
		super();
		this.nom = nom;
	}

	public Role(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
