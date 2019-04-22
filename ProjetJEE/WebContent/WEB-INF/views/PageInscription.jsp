<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'inscription</title>
</head>
<body>

	<header>
	<!-- Titre page -->
		<div>
			<h1 class="titre_page">Inscription</h1>
		</div>
	</header>
	
	<nav>
		<ul>				 
		  <li><a href="PageConnexion.html"><span>Connexion</span></a></li>
		</ul>
	</nav>
	
	<!-- Formulaire d'inscription -->
	<form action="" method="post">
		<div>
	        <label for="name">Nom :</label>
	        <input type="text">
	    </div>
	    <div>
	        <label for="name">Prénom :</label>
	        <input type="text">
	    </div>
	    <div>
	        <label>Adresse mail :</label>
	        <input class="adress_mail" type="email">
	    </div>
	    <div>
	        <label for="password">Mot de passe :</label>
	        <input class="password" type="text">
	    </div>
	   	<div>
	        <label for="password">Confirmation du mot de passe :</label>
	        <input class="password" type="text">
	    </div>
	      <div>
	        <label>Comment avez-vous connu nos restaurants ?</label>
	        <input type="text">
	    </div>
	    
	    <div class="button">
      	  <button type="submit">Valider mon inscription</button>
    	</div>
	</form>
	
	<footer>
		<div>
			<a class="accueil" href="PageAccueil.html"><span>Revenir à la page d'accueil</span></a>
		</div>
	</footer>
	
</body>
</html>