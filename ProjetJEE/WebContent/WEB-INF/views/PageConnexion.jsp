<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connexion</title>
</head>

<body>

	<header>
		<!-- Titre page -->
		<div>
			<h1 class="titre_page">Page de connexion</h1>
		</div>
	</header>
	
	<nav>
		<ul>		  			 
		  <li><a href="PageInscription.html"><span>Inscription</span></a></li>
		</ul>
	</nav>
	
	<!-- Formulaire de connexion -->
	<form action="" method="post">
	    <div>
	        <label>Adresse mail :</label>
	        <input type="email">
	    </div>
	    <div>
	        <label>Mot de passe :</label>
	        <input type="text">
	    </div>
	    
	    <div class="button">
      	  <button type="submit">Valider</button>
    	</div>
	</form>
	
	<footer>
		<div>
			<a class="accueil" href="PageAccueil.html"><span>Revenir Ã  la page d'accueil</span></a>
		</div>
	</footer>
	
</body>
</html>