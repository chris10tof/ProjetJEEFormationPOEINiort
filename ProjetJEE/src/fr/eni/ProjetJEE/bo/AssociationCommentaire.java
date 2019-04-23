package fr.eni.ProjetJEE.bo;

public class AssociationCommentaire {
	private int idAssociation;
	private Personne personneId;
	private Plat platId;
	private Restaurant restaurantId;
	private Commentaire commentaireId;
	
	public AssociationCommentaire() {
		super();
	}
	
	public AssociationCommentaire(Personne personneId, Plat platId, Restaurant restaurantId, Commentaire commentaireId) {
		super();
		this.personneId = personneId;
		this.platId = platId;
		this.restaurantId = restaurantId;
		this.commentaireId = commentaireId;
	}

	public AssociationCommentaire(int idAssociation, Personne personneId, Plat platId, Restaurant restaurantId, Commentaire commentaireId) {
		super();
		this.idAssociation = idAssociation;
		this.personneId = personneId;
		this.platId = platId;
		this.restaurantId = restaurantId;
		this.commentaireId = commentaireId;
	}

	public int getIdAssociation() {
		return idAssociation;
	}

	public void setIdAssociation(int idAssociation) {
		this.idAssociation = idAssociation;
	}

	public Personne getPersonneId() {
		return personneId;
	}

	public void setPersonneId(Personne personneId) {
		this.personneId = personneId;
	}

	public Plat getPlatId() {
		return platId;
	}

	public void setPlatId(Plat platId) {
		this.platId = platId;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Commentaire getCommentaireId() {
		return commentaireId;
	}

	public void setCommentaireId(Commentaire commentaireId) {
		this.commentaireId = commentaireId;
	}
}
