<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>>
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
	<H1 class="text-center">Ajout d'une commande</h1>


	<div class="container" style="max-width: 600px; margin: 60px auto;">
		<form method="post"
			action="http://localhost:8080/TpCommandes/AjoutCommandes">
			<div class="form-group">
				<label for="name">date</label> <input type="name"
					class="form-control" id="date" name="date"
					placeholder="Entrer la date de la commande">
			</div>
			<div class="form-group">
				<label for="name">numéro commande</label> <input type="name"
					class="form-control" id="numC" name="numC"
					placeholder="Entrer le numéro de la commande">
			</div>

			<select name="listeClients">
				<c:forEach items="${lesClients}" var="element">
					<option>${element}</option>
				</c:forEach>
			</select>

			<button type="submit" class="btn btn-default">Ajouter la
				commande</button>
		</form>

	</div>
	</select>
</body>
</html>