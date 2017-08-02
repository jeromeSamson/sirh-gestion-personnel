<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>
<body>

	<!-- Text input-->
	<form class="form-horizontal" method="post">
		<fieldset>
			<legend>
				<h1>Nouveau Collaborateur</h1>
			</legend>

			<div class="form-group">
				<label class="col-md-3 control-label" for="nom">Nom</label>
				<div class="col-md-3">
					<input id="nom" name="nom" type="text" placeholder="Nom"
						class="form-control input-md" required="">
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="prenom">Prenom</label>
				<div class="col-md-3">
					<input id="prenom" name="prenom" type="text" placeholder="Prenom"
						class="form-control input-md" required="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="dateNaissance">Date de naissance</label>
				<div class="col-md-3">
					<input id="dateNaissance" type="date" name="dateNaissance"
						class="form-control input-md" required="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="adresse">Adresse</label>
				<div class="col-md-3">
					<input id="adresse" type="Text" name="adresse"
						class="form-control input-md" required="">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="numSecu">Numéro sécurité social</label>
				<div class="col-md-3">
					<input id="numSecuSocial" type="text" pattern="[1-2][0-9]{14}" title="Veuillez saisir un numéro de sécurité social valide 15 chiffres " name="numSecu" class="form-control input-md" required="">
				</div>
			</div>
			<div class="form-group col-md-12 control-label">
				<button type="submit" id="singlebutton" name="creer" class="btn btn-primary">Créer</button>
			</div>
		</fieldset>
	</form>
</body>
</html>