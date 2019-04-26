package fr.eni.ProjetJEE.bo;

public class Restaurant {
	private int id;
	private String localisation;
	private int nbretable;
	private String uriResto;
	private double localisationX;
	private double localisationY;
	
	public Restaurant() {
		super();
	}

	public Restaurant(String localisation, int nbretable, String uriResto, double localisationX, double localisationY) {
		super();
		this.localisation = localisation;
		this.nbretable = nbretable;
		this.uriResto = uriResto;
		this.localisationX = localisationX;
		this.localisationY = localisationY;
	}

	public Restaurant(int id, String localisation, int nbretable, String uriResto, double localisationX, double localisationY) {
		super();
		this.id = id;
		this.localisation = localisation;
		this.nbretable = nbretable;
		this.uriResto = uriResto;
		this.localisationX = localisationX;
		this.localisationY = localisationY;
	}
	
	public Restaurant(int id, String localisation) {
		super();
		this.id = id;
		this.localisation = localisation;
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
	
	public double getLocalisationX() {
		return localisationX;
	}

	public void setLocalisationX(double localisationX) {
		this.localisationX = localisationX;
	}

	public double getLocalisationY() {
		return localisationY;
	}

	public void setLocalisationY(double localisationY) {
		this.localisationY = localisationY;
	}
}
