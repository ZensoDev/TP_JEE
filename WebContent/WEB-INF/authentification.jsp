<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Authentification</title>
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
	<H1 class="text-center">Authentification</h1>


	<div class="container" style="max-width: 600px; margin: 60px auto;">
		<form method="post" action="http://localhost:8080/TpCommandes/Authentification">
			<div class="form-group">
				<label for="name">Nom</label> <input type="name"
					class="form-control" id="nom" name="nomUser"
					placeholder="Entrer votre nom"> <FONT color="red">${ logKo }</FONT>
			</div>
			<div class="form-group">
				<label for="name">Password</label> <input type="Password"
					class="form-control" id="Password" name="mdpUser"
					placeholder="Entrer votre mot de passe"><FONT color="red">${ logKo }</FONT>
			</div>

			<button type="submit" class="btn btn-default">Se connecter</button>
		</form>
	</div>
</body>
</html>