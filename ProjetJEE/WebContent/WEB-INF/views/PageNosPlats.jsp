<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page : nos plats</title>
</head>
<body>

	<header>
		<!-- Nom du restaurant -->
		<div>
			<h1 class="titre_page">Restaurant 101</h1>
		</div>
		
		<!-- Titre page -->
		<div>
			<h1 class="titre_page">Nos plats</h1>
		</div>
	</header>
	
	<nav>
		<ul>
		<!-- Quand on est pas connecté -->
		  <li><a class="suivre" href="PageInscription.html"><span>Inscription</span></a></li>	
		  
		  <li><a class="suivre" href="PageConnexion.html"><span>Connexion</span></a></li>
		  
		<!-- Quand on est connecté -->
		  <li><a class="pour_les_connectes" href="PageMonCompte.html"><span>Connexion</span></a></li>
		  
		  <li><a class="pour_les_connectes" href="Forum.html"><span>Forum</span></a></li>
		  
		<!-- Quand l'ADMIN est connecté -->
		  <li><a class="pour_admin" href="PageAjoutPlat.html"><span>Connexion</span></a></li>  
		</ul>
	</nav>
	
		<!-- Carrousel d'image -->
	<main>
		<div id="carrousel_plats">
			<figure>
				<img src = "salade_automne_champignons_sautes.jpg" alt = "Notre salade Automne aux champignons sautes">
				<img src = "salade_chevre_chaud.jpg" alt = "Notre salade Chèvre chaud">
				<img src = "taboule_libanais.jpg" alt = "Notre taboulé libanais">
				<img src = "chiktaye_morue_guadeloupe.jpg" alt = "Notre chiktaye à la morue de Guadeloupe">
				<img src = "burger_avocat_bacon.jpg" alt = "Notre burger à l'avocat et au bacon">
				<img src = "cake_banane_chocolat.jpg" alt = "Notre cake à la bananee et au chocolat">
				<img src = "tarte_tatin.jpg" alt = "Notre tarte tatin">
			</figure>
		</div>
	</main>
		
	<footer>
		<div>
			<a class="accueil" href="PageAccueil.html"><span>Revenir à la page d'accueil</span></a>
		</div>
	</footer>
	


	

</body>
</html>