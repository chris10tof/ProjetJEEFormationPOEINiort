package fr.eni.ProjetJEE.bo;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String uriAvatar;
	private Role role;
	
	
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String email, String mdp, String uriAvatar, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.uriAvatar = uriAvatar;
		this.role = role;
	}

	public Personne(int id, String nom, String prenom, String email, String mdp, String uriAvatar, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.uriAvatar = uriAvatar;
		this.role = role;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getUriAvatar() {
		return uriAvatar;
	}

	public void setUriAvatar(String uriAvatar) {
		this.uriAvatar = uriAvatar;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
