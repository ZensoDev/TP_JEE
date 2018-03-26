<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Ajouter client</title>
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
	<H1 class="text-center">Ajouter client</h1>

<div class="text-center">
	<div class="container" style="max-width: 600px; margin: 60px auto;">
		<form method="post" action="http://localhost:8080/TpCommandes/AjoutClients">
			<div class="form-group">
				<label for="name">Nom</label> <input type="name"
					class="form-control" id="nom" name="nom" placeholder="Entrer votre nom">
			</div>
			<div class="form-group">
				<label for="name">Prénom</label> <input type="name"
					class="form-control" id="prenom" name="prenom" placeholder="Entrer votre prénom">
			</div>
			<button type="submit" class="btn btn-default">Enregistrer</button>
		</form>
		</div>
	</div>

</body>
</html>