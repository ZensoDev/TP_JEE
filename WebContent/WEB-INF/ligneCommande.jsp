<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Commande</title>
<meta name="viewport" content="width=device-width, initialscale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/bootstrap.min.js"></script>
</head>
<body>
	<H1 class="text-center">Création d'une commande</h1>


	<div class="container" style="max-width: 600px; margin: 60px auto;">
		<form method="post"
			action="http://localhost:8080/TpCommandes/LigneCommande">

			<select name="listeArticles" >
				<c:forEach items="${lesArticles}" var="element"> 
					<option>${element}</option>
				</c:forEach>
			</select>
			<div class="form-group">
				<label for="name">Quantité</label> <input type="quantite"
					class="form-control" id="quantite" name="quantite"
					placeholder="Entrer la quantité">${ quantiteTest } ${ existDejaTest }
			</div>

			<select name="listeCommandes">
				<c:forEach items="${lesCommandes}" var="element">
					<option>${element}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-default">Ajouter</button>
		</form>

	</div>

</body>
</html>