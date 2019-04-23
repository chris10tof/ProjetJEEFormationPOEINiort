package fr.eni.ProjetJEE.bo;

public class Restaurant {
	private int id;
	private String localisation;
	private int nbretable;
	private String uriResto;
	
	public Restaurant() {
		super();
	}

	public Restaurant(String localisation, int nbretable, String uriResto) {
		super();
		this.localisation = localisation;
		this.nbretable = nbretable;
		this.uriResto = uriResto;
	}

	public Restaurant(int id, String localisation, int nbretable, String uriResto) {
		super();
		this.id = id;
		this.localisation = localisation;
		this.nbretable = nbretable;
		this.uriResto = uriResto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getNbretable() {
		return nbretable;
	}

	public void setNbretable(int nbretable) {
		this.nbretable = nbretable;
	}

	public String getUriResto() {
		return uriResto;
	}

	public void setUriResto(String uriResto) {
		this.uriResto = uriResto;
	}
}
