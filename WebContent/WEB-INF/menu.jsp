<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title></title>
</head>

<body>
	<nav class="navbar navbar-default sidebar" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-sidebar-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-sidebar-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/Authentification"><span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span>
					</a></li>
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/AjoutClients">Client<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-plus"></span>
					</a></li>
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/SupprClients">Client<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-minus"></span>
					</a></li>

					<li class="active"><a
						href="http://localhost:8080/TpCommandes/AjoutArticles">Article<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-plus"></span>
					</a></li>

					<li class="active"><a
						href="http://localhost:8080/TpCommandes/SupprArticles">Supprimer<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-minus"></span>
					</a></li>

					<li class="active"><a
						href="http://localhost:8080/TpCommandes/AjoutCommandes">Commande<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-plus"></span>
					</a></li>

					<li class="active"><a
						href="http://localhost:8080/TpCommandes/SupprCommandes">Commande<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-minus"></span>
					</a></li>
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/Commande">Commande<span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-question-sign"></span>
					</a></li>
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/LigneCommande">
							Création cmd<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span>
					</a></li>
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/Menu">Bonjour <B>${sessionScope.SessNom}</B>.
							<span style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span>
					</a></li>
					<li class="active"><a
						href="http://localhost:8080/TpCommandes/Deco">Deconnecter <span
							style="font-size: 16px;"
							class="pull-right hidden-xs showopacity glyphicon glyphicon-remove"></span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>