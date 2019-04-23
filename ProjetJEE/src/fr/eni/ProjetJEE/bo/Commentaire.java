package fr.eni.ProjetJEE.bo;

import java.sql.Date;

public class Commentaire {
	private int id;
	private String contenu;
	private Date date;
	private double note;
	
	public Commentaire() {
		super();
	}

	public Commentaire(String contenu, Date date, double note) {
		super();
		this.contenu = contenu;
		this.date = date;
		this.note = note;
	}

	public Commentaire(int id, String contenu, Date date, double note) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.date = date;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
}
