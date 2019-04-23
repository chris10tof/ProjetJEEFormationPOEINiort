package fr.eni.ProjetJEE.bo;

public class Reservation {
	private int id;
	private int table;
	private String nom;
	private String tel;
	private int nbrePersonne;
	
	public Reservation() {
		super();
	}

	public Reservation(int table, String nom, String tel, int nbrePersonne) {
		super();
		this.table = table;
		this.nom = nom;
		this.tel = tel;
		this.nbrePersonne = nbrePersonne;
	}

	public Reservation(int id, int table, String nom, String tel, int nbrePersonne) {
		super();
		this.id = id;
		this.table = table;
		this.nom = nom;
		this.tel = tel;
		this.nbrePersonne = nbrePersonne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getNbrePersonne() {
		return nbrePersonne;
	}

	public void setNbrePersonne(int nbrePersonne) {
		this.nbrePersonne = nbrePersonne;
	}
}
