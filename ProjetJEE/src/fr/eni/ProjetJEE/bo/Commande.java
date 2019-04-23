package fr.eni.ProjetJEE.bo;

public class Commande {
	private int idCommande;
	private Table tableId;
	private Plat platId;
	private double nbrePlat;
	
	public Commande() {
		super();
	}
		
	public Commande(Table tableId, Plat platId, double nbrePlat) {
		super();
		this.tableId = tableId;
		this.platId = platId;
		this.nbrePlat = nbrePlat;
	}
	
	public Commande(int idCommande, Table tableId, Plat platId, double nbrePlat) {
		super();
		this.idCommande = idCommande;
		this.tableId = tableId;
		this.platId = platId;
		this.nbrePlat = nbrePlat;
	}

	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public Table getTableId() {
		return tableId;
	}
	public void setTableId(Table tableId) {
		this.tableId = tableId;
	}
	public Plat getPlatId() {
		return platId;
	}
	public void setPlatId(Plat platId) {
		this.platId = platId;
	}
	public double getNbrePlat() {
		return nbrePlat;
	}
	public void setNbrePlat(double nbrePlat) {
		this.nbrePlat = nbrePlat;
	}
}
