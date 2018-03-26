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
	<H1 class="text-center">Supprimer client</h1>


	<div class="container" style="max-width: 600px; margin: 60px auto;">
		<form method="post" action="SupprClients">
			<div class="text-center">
				<select name="listeClients">
					<c:forEach items="${lesClients}" var="element">
						<option>${element}</option>
					</c:forEach>
				</select>
			</div>
			<br> <br> <br>
			<H3 class="text-center">Attention ! La suppression d'un client
				entraine la suppression de ses commandes</h3>
			<br> <br> <br> <br> <br> <br>
			<div class="text-center">
				<button type="submit" class="btn btn-default">Supprimer</button>
			</div>
		</form>

	</div>
</body>
</html>