<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page accueil</title>
<link rel="stylesheet" href="Pages.css" />
</head>

<body>

	<header>
		<!-- Nom du restaurant -->
		<div>
			<h1 class="nom_restaurant">Restaurant 101</h1>
		</div>
	</header>
	
	<div>
		<a class="nos_plats" href="PageNosPlats.html"><span>Nos plats</span></a>
	</div>
	
	<nav>
		<ul>
		<!-- Quand on est pas connect� -->
		  <li><a class="suivre" href="PageInscription.html"><span>Inscription</span></a></li>	
		  
		  <li><a class="suivre" href="PageConnexion.html"><span>Connexion</span></a></li>
		  
		<!-- Quand on est connect� -->
		  <li><a class="pour_les_connectes" href="PageMonCompte.html"><span>Connexion</span></a></li>
		  
		  <li><a class="pour_les_connectes" href="Forum.html"><span>Forum</span></a></li>
		  
		<!-- Quand l'ADMIN est connect� -->
		  <li><a class="pour_admin" href="PageAjoutPlat.html"><span>Connexion</span></a></li>  
		</ul>
	</nav>
	
	<main>
	
	<!-- PRESENTATION RESTAURANT DE RENNES -->
	
		<!-- Photographie du restaurant de Rennes -->
		<div>
			<img src="Image_restaurant_Rennes.jpg" alt="Photographie du restaurant 101 de Rennes" />
		</div>
		
		<!-- Description restaurant de Rennes -->
		<p>Notre restaurant est compos� de 15 tables</p>
		
		<!-- G�olocalisation Restaurant de Rennes avec l'API Google MAPS-->
		<div>
			<!-- Le param�tre "sensor"= d�terminer la position de l'utilisateur -->
			<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
			<script type="text/javascript">
				function initialiser() {
					var latlng = new google.maps.LatLng(48.1113387, -1.6800198);
					//objet contenant des propri�t�s avec des identificateurs pr�d�finis dans Google Maps permettant
					//de d�finir des options d'affichage de notre carte
					var options = {
						center: latlng,
						zoom: 19,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					};
					
					//constructeur de la carte qui prend en param�tre le conteneur HTML
					//dans lequel la carte doit s'afficher et les options
					var carte = new google.maps.Map(document.getElementById("carte"), options);
				}
			</script>
		</div>
		
		<!-- PRESENTATION RESTAURANT DE NANTES -->
	
		<!-- Photographie du restaurant de Nantes -->
		<div>
			<img src="Image_restaurant_Nantes.jpg" alt="Photographie du restaurant 101 de Nantes" />
		</div>
		
		<!-- Description restaurant de Nantes -->
		<p>Notre restaurant est compos� de 10 tables</p>
		
		<!-- G�olocalisation Restaurant de Nantes avec l'API Google MAPS-->
		<div>
			<!-- Le param�tre "sensor"= d�terminer la position de l'utilisateur -->
			<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
			<script type="text/javascript">
				function initialiser() {
					var latlng = new google.maps.LatLng(47.2186371, -1.5541362);
					//objet contenant des propri�t�s avec des identificateurs pr�d�finis dans Google Maps permettant
					//de d�finir des options d'affichage de notre carte
					var options = {
						center: latlng,
						zoom: 19,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					};
					
					//constructeur de la carte qui prend en param�tre le conteneur HTML
					//dans lequel la carte doit s'afficher et les options
					var carte = new google.maps.Map(document.getElementById("carte"), options);
				}
			</script>
		</div>
		
		<!-- PRESENTATION RESTAURANT DE BREST -->
	
		<!-- Photographie du restaurant de Brest -->
		<div>
			<img src="Image_restaurant_Brest.jpg" alt="Photographie du restaurant 101 de Brest" />
		</div>
		
		<!-- Description restaurant de Rennes -->
		<p>Notre restaurant ouvrira prochainement</p>
		
		<!-- G�olocalisation Restaurant de Brest avec l'API Google MAPS-->
		<div>
			<!-- Le param�tre "sensor"= d�terminer la position de l'utilisateur -->
			<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
			<script type="text/javascript">
				function initialiser() {
					var latlng = new google.maps.LatLng(48.3905283, -4.4860088);
					//objet contenant des propri�t�s avec des identificateurs pr�d�finis dans Google Maps permettant
					//de d�finir des options d'affichage de notre carte
					var options = {
						center: latlng,
						zoom: 19,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					};
					
					//constructeur de la carte qui prend en param�tre le conteneur HTML
					//dans lequel la carte doit s'afficher et les options
					var carte = new google.maps.Map(document.getElementById("carte"), options);
				}
			</script>
		</div>

	</main>
	
</body>

</html>