<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Ajouter Article</title>
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
	<H1 class="text-center">Ajouter article</h1>


	<div class="container" style="max-width: 600px; margin: 60px auto;">
		<form method="post" action="http://localhost:8080/TpCommandes/AjoutArticles">
			<div class="form-group">
				<label for="name">Désignation</label> <input type="name"
					class="form-control" id="nom" name="designation"
					placeholder="Entrer le nom de l'article">
			</div>
			<div class="form-group">
				<label for="name">Prix</label> <input type="name"
					class="form-control" id="prix" name="prix"
					placeholder="Entrer son prix">
			</div>
			<div class="form-group">
				<label for="name">Stock</label> <input type="name"
					class="form-control" id="stock" name="stock"
					placeholder="Entrer le stock">
			</div>
			<button type="submit" class="btn btn-default">Enregistrer</button>
		</form>
	</div>
</body>
</html>