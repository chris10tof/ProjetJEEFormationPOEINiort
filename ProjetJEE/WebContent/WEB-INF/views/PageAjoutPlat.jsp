<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un plat</title>
</head>

<body>

	<main>	
	<!-- Formulaire d'ajout d'un plat -->
		<form action="" method="post">
		    <div>
		        <label>Nom du plat :</label>
		        <input type="text">
		    </div>
		    <div>
		        <label>Image du plat :</label>
		        <input type="file" ">
		    </div>
		    
		    <div>
		        <label>Descriptif du plat :</label>
		        <input type="text">
		    </div>
		    
		    <div>
		        <label>Liste des ingrédients présents dans le plat :</label>
		        <input type="text">
		    </div>
		    
		    <div class="button">
	      	  <button type="submit">Valider le nouveau plat</button>
	    	</div>
		</form>
	</main>

</body>
</html>