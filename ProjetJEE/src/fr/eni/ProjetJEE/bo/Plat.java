package fr.eni.ProjetJEE.bo;

public class Plat {
	private int id;
	private String nom;
	private String description;
	private double prix;
	private String recette;
	private String uriImage;
	private Categorie categorie;
	private int nbrCommande;
	
	public Plat() {
		super();
	}
	
	public Plat(String nom, String description, double prix, String recette, String uriImage, Categorie categorie,
			int nbrCommande) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.recette = recette;
		this.uriImage = uriImage;
		this.categorie = categorie;
		this.nbrCommande = nbrCommande;
	}
	
	public Plat(int id, String nom, String description, double prix, String recette, String uriImage,
			Categorie categorie, int nbrCommande) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.recette = recette;
		this.uriImage = uriImage;
		this.categorie = categorie;
		this.nbrCommande = nbrCommande;
	}
	
	public Plat(String nom, String description, double prix, String recette, String uriImage, Categorie categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.recette = recette;
		this.uriImage = uriImage;
		this.categorie = categorie;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getRecette() {
		return recette;
	}
	public void setRecette(String recette) {
		this.recette = recette;
	}
	public String getUriImage() {
		return uriImage;
	}
	public void setUriImage(String uriImage) {
		this.uriImage = uriImage;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public int getNbrCommande() {
		return nbrCommande;
	}
	public void setNbrCommande(int nbrCommande) {
		this.nbrCommande = nbrCommande;
	}
}
